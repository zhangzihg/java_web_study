package com.zzh.service;

import com.zzh.pojo.User;

public interface UserService {
    /**
     * 用户登录
     * @param user 注册用户信息
     */
    public void userRegister(User user);
    public User userLogin(User uer);

    /**
     * 检查用户是否存在
     * @param username
     * @return
     */
    public boolean existsCheckedUser(String username);

}
