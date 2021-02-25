package com.zzh.test;

import com.zzh.dao.UserDao;
import com.zzh.dao.com.zzh.dao.impl.UserDaoImpl;
import com.zzh.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoTest {
    private UserDao userDao = new UserDaoImpl();
    @Test
    public void selectUserByUsername() {
        System.out.println(userDao.selectUserByUsername("admin"));
        System.out.println(userDao.selectUserByUsername("zs"));
    }

    @Test
    public void selectUserByUsernameAndPwd() {
        System.out.println(userDao.selectUserByUsernameAndPwd("zs", "admin"));
    }

    @Test
    public void addUser() {
        User user = new User(3, "lisi", "lisi", "123@qq.com");
        userDao.addUser(user);
    }
}