package com.zzh.web;

import com.zzh.pojo.User;
import com.zzh.service.UserService;
import com.zzh.service.com.zzh.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = (String)req.getParameter("username");
        String password = (String)req.getParameter("password");
        String email = (String)req.getParameter("email");
        String identifyingCode = (String )req.getParameter("identifyingCode");
        User registerUser = new User(null, username, password, email);
        //校验验证码是否正确
        if("123456".equals(identifyingCode)){
            if (userService.existsCheckedUser(registerUser.getUsername())) {
                //用户已存在回到注册页面
                req.getRequestDispatcher("/pages/user/regist.html").forward(req, resp);
            }else {

                userService.userRegister(registerUser);
//                用户注册成功
                req.getRequestDispatcher("/pages/user/regist_success.html").forward(req, resp);
            }
        }


    }
}
