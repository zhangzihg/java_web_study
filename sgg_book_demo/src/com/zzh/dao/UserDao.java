package com.zzh.dao;

import com.zzh.pojo.User;

public interface UserDao {
    /**
     * 根据用户名查用户
     * @param username 用户名
     * @return null代表没有该用户，又该用户则返回
     */
    public User selectUserByUsername(String username);

    /**
     * 根据用户名和密码查询用户
     * @param username 用户名
     * @param pwd  密码
     * @return  null代表没有该用户，有则返回
     */
    public User selectUserByUsernameAndPwd(String username,String pwd);

    /**
     * 添加该用户到数据库
     * @param user
     * @return 大于0：添加成功 小于0失败
     */
    public int addUser(User user);
}
