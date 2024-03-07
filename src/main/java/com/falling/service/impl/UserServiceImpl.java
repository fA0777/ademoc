package com.falling.service.impl;

import com.falling.mapper.UserMapper;
import com.falling.pojo.User;
import com.falling.service.UserService;
import com.falling.util.SaltFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User login(String name, String password){
        User user = userMapper.select(name);
        if (user==null){
            return user;
        }
        String password1 = password.trim();
        String salt = user.getSalt();
        password1+=salt;
        int hashCode = password1.hashCode();
        String password2=""+hashCode;
        if (password2.equals(user.getPassword())){
            return user;
        }
        return null;
    }

    @Override
    public boolean register(User user) {
        System.out.println(4.1);
        User u = userMapper.select(user.getName());
        System.out.println(4.2);
        if (u==null){
            //用户名不存在，可注册
            //生成盐
            System.out.println(4.3);
            String salt= SaltFactory.getSalt();
            user.setSalt(salt);
            //生成密文密码
            String password = user.getPassword().trim();
            String password1=password+salt;
            int hashCode = password1.hashCode();
            String password2=""+hashCode;
            user.setPassword(password2);
            user.setProfilePhoto("img\\img_default.jpg");
            user.setStatus(1);
            System.out.println(4.4);
            userMapper.addUser(user);
            //提交事务
            return true;
        }
        System.out.println(4.5);
        return false;
    }
}
