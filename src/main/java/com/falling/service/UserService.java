package com.falling.service;

import com.falling.pojo.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public interface UserService {

    /**
     * 用户登录
     * @param name
     * @param password
     * @return
     */
    User login(String name, String password);

    /**
     * 用户注册
     * @param user
     * @return
     */
    boolean register(User user);
}
