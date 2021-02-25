package com.zzh.web;

import com.zzh.pojo.User;
import com.zzh.service.UserService;
import com.zzh.service.com.zzh.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取用户输入的信息
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        User user1 = userService.userLogin(user);

        if (user1 != null) {
//            /登录成功
            req.getRequestDispatcher("/pages/user/login_success.html").forward(req, resp);
        }else {
//            登录失败
            req.getRequestDispatcher("/pages/user/login.html").forward(req, resp);
        }

    }
}
