package com.example.Minorproject.Digital.library;

import com.example.Minorproject.Digital.library.Models.Admin;
import com.example.Minorproject.Digital.library.Models.MyUser;
import com.example.Minorproject.Digital.library.Models.Student;
import com.example.Minorproject.Digital.library.enums.AccountStatus;
import com.example.Minorproject.Digital.library.repository.AdminRepositoryInterf;
import com.example.Minorproject.Digital.library.repository.MyUserRepositoryInterf;
import com.example.Minorproject.Digital.library.repository.StudentRepositoryInterf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class MinorProjectDigitalLibraryApplication implements CommandLineRunner {
	@Autowired
	StudentRepositoryInterf studentRepositoryInterf;

	@Autowired
	MyUserRepositoryInterf myUserRepositoryInterf;

	@Autowired
	AdminRepositoryInterf adminRepositoryInterf;

	@Autowired
	PasswordEncoder passwordEncoder;
	@Value("${users.authority.student}")
	String studentAuthority;

	@Value("${users.authority.admin}")
	String adminAuthority;


	private static Logger logger = LoggerFactory.getLogger(MinorProjectDigitalLibraryApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MinorProjectDigitalLibraryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("In Run function of main class");

//		MyUser myUser= MyUser.builder().userName("raj")
//						.password(passwordEncoder.encode("raj123")).authority(adminAuthority)
//						.build();
//		myUser=myUserRepositoryInterf.save(myUser);
//
//		Admin admin=Admin.builder()
//				.age(34).name("raj shah").email("raj@gmail.com")
//				.myUser(myUser)
//				.build();
//
//		adminRepositoryInterf.save(admin);
//		MyUser studentUser =MyUser.builder()
//				.userName("john")
//		        .password(passwordEncoder.encode("john123")).authority(studentAuthority)
//				.build();
//		studentUser=myUserRepositoryInterf.save(studentUser);
//
//		Student student= Student.builder()
//				.name("john cena")
//				.email("john@gmail.com")
//				.address("india")
//				.accountStatus(AccountStatus.ACTIVE)
//				.contact("9753740840")
//				.myUser(studentUser)
//				.build();
//		studentRepositoryInterf.save(student);
	}
}
