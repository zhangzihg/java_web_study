package com.zzh.test;

import com.zzh.pojo.User;
import com.zzh.service.UserService;
import com.zzh.service.com.zzh.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {
    UserService userService = new UserServiceImpl();
    @Test
    public void userRegister() {
        userService.userRegister(new User(null,"user01","pwd01","email-01"));
        userService.userRegister(new User(null,"user02","pwd02","email-01"));
    }

    @Test
    public void userLogin() {
        User user = new User();
        user.setUsername("zs");
        user.setPassword("23");
        System.out.println(userService.userLogin(user));
    }

    @Test
    public void existsCheckedUser() {
        User user = new User();
        user.setUsername("user011");
        System.out.println(userService.existsCheckedUser(user.getUsername()));
    }
}