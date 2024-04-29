package com.example.Minorproject.Digital.library.serviceImpl;

import com.example.Minorproject.Digital.library.Models.MyUser;
import com.example.Minorproject.Digital.library.RepositoryImpl.MyUserCacheRepository;
import com.example.Minorproject.Digital.library.repository.MyUserRepositoryInterf;
import com.example.Minorproject.Digital.library.requests.UserCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Value("${users.authority.student}")
    String studentAuthority;

    @Value("${users.authority.admin}")
    String adminAuthority;
    @Autowired
    MyUserRepositoryInterf myUserRepositoryInterf;

    @Autowired
    MyUserCacheRepository myUserCacheRepository;

    //    @Autowired
//    MyUserDetailsService myUserDetailsService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser myUser = myUserCacheRepository.get(username);

        // fetch from database if its not present in cache
        if(myUser == null){
            myUser = myUserRepositoryInterf.findByUserName(username);
            if(myUser != null){
                myUserCacheRepository.set(myUser);
            }
        }
        return myUser;
    }

    public MyUser createUser(UserCreateRequest userCreateRequest) {

        MyUser.MyUserBuilder myUserBuilder = MyUser.builder()
                .userName(userCreateRequest.getUsername())
                .password(passwordEncoder.encode(userCreateRequest.getPassword()));
        if(userCreateRequest.getStudent() != null){
            myUserBuilder.authority(studentAuthority);
        } else {
            myUserBuilder.authority(adminAuthority);
        }
        return myUserRepositoryInterf.save(myUserBuilder.build());

    }

}
