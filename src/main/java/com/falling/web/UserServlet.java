package com.falling.web;

import com.falling.config.SpringConfig;
import com.falling.pojo.User;
import com.falling.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/user/*")
public class UserServlet extends BaseServlet {
    @Autowired
    UserService userService;
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用户名和密码
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        //获取复选框数据
        String remember = request.getParameter("remember");

        //调用Service查询
        User user = userService.login(name, password);
        //判断
        if(user!=null){
            //登录成功，跳转到用户页面
            //判断用户是否勾选“remember”，用equals判断，把字符串写前面，可防止空指针异常
            if ("1".equals(remember)){
                //勾选了，发送cookie
                //创建cookie对象
                Cookie c_name=new Cookie("name",name);
                Cookie c_password=new Cookie("password",password);

                //设置cookie存活时间 一周
                c_name.setMaxAge(60*60*24*7);
                c_password.setMaxAge(60*60*24*7);

                //发送cookie
                response.addCookie(c_name);
                response.addCookie(c_password);
            }

            //将登录成功后的User对象存储到session中
            HttpSession session = request.getSession();
            session.setAttribute("user",user);

            //重定向
            String contextPath=request.getContextPath();
            response.sendRedirect(contextPath+"/user.html");

        }else{
            //登录失败
            //存储错误信息到request
            request.setAttribute("login_msg","用户名或密码错误");

            //跳转到login.jsp，携带错误信息提示
            request.getRequestDispatcher("/userLogin.jsp").forward(request,response);
        }
    }

    public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //获取用户名和密码
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        //获取用户输入的验证码
        String checkCode = request.getParameter("checkCode");

        //获取程序生成的验证码，从session中获取
        HttpSession session = request.getSession();
        String checkCodeGen = (String) session.getAttribute("checkCodeGen");

        //比对两个验证码
        if (!checkCode.equalsIgnoreCase(checkCodeGen)){
            //不允许注册
            request.setAttribute("register_msg","验证码错误");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
            return;
        }

        //封装为User对象
        User user=new User();
        user.setName(name);
        user.setPassword(password);

        //调用service注册
        boolean flag = userService.register(user);

        //判断注册成功与否
        if(flag){
            //注册成功，跳转到登录页面
            request.setAttribute("register_msg","注册成功，请登录");
            request.getRequestDispatcher("/userLogin.jsp").forward(request,response);
        }else{
            //注册失败，跳转到注册页面
            request.setAttribute("register_msg","用户名已存在");
            request.getRequestDispatcher("/userRegister.jsp").forward(request,response);
        }
    }

    }
