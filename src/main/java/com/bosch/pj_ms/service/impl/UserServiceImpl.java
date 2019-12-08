package com.bosch.pj_ms.service.impl;

import com.bosch.pj_ms.mapper.UserMapper;
import com.bosch.pj_ms.pojo.User;
import com.bosch.pj_ms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findUserByNameAndPasswd(String username, String password) {
        return userMapper.selectUserByNameAndPasswd(username, password);
    }
}
