package com.bosch.pj_ms.service;

import com.bosch.pj_ms.pojo.User;

import java.util.List;

public interface UserService {

    List<User> findUserByNameAndPasswd(String username, String password);
}
