package com.zzh.service.com.zzh.service.impl;

import com.zzh.dao.UserDao;
import com.zzh.dao.com.zzh.dao.impl.UserDaoImpl;
import com.zzh.pojo.User;
import com.zzh.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    /**
     * 用户注册
     * @param user 注册用户信息
     */
    @Override
    public void userRegister(User user) {
        userDao.addUser(user);
    }

    /**
     * 用户登录
     * @param user 登录的用户名
     * @return null,用户账号密码错误，有值说明正确
     */
    @Override
    public User userLogin(User user) {
        return userDao.selectUserByUsernameAndPwd(user.getUsername(),user.getPassword());
    }

    /**
     * 根据用户名检查用户是否存在
     * @param username
     * @return true 存在；false不存在
     */
    @Override
    public boolean existsCheckedUser(String username) {

        return  userDao.selectUserByUsername(username) == null ? false : true;
    }
}
