package com.example.Minorproject.Digital.library.RepositoryImpl;

import com.example.Minorproject.Digital.library.Models.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

@Repository
public class MyUserCacheRepository {
    private static final String USER_KEY_PREFIX = "usr::";

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    public void set(MyUser myUser){
        String key = getKey(myUser.getUsername());
        redisTemplate.opsForValue().set(key, myUser,24, TimeUnit.HOURS);
    }

    public MyUser get(String username){
        return (MyUser) redisTemplate.opsForValue().get(getKey(username));
    }

    private String getKey(String username){
        return USER_KEY_PREFIX+username;
    }


}
