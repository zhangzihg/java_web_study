package com.zzh.dao.com.zzh.dao.impl;

import com.zzh.dao.BaseDao;
import com.zzh.dao.UserDao;
import com.zzh.pojo.User;

public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User selectUserByUsername(String username) {
        return queryForOne(User.class, "select * from t_user where username=?", username);
    }

    @Override
    public User selectUserByUsernameAndPwd(String username, String pwd) {
        Object[] args = {username,pwd};
        return queryForOne(User.class, "select * from t_user where username=? and password = ?",args);
    }

    @Override
    public int addUser(User user) {
        String sql = "insert into t_user set id=?,username=?,password=?,email=?";
        Object[] args = {user.getId(),user.getUsername(),user.getPassword(),user.getEmail()};
        return update(sql,args);
    }
}
