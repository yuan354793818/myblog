package com.yjy.service;

import com.yjy.dto.CommonDto;
import com.yjy.pojo.User;

import java.util.List;

public interface UserService {
    CommonDto<User> regist(User user);

    CommonDto<User> login(User user);

    CommonDto logout(User user);

    CommonDto updatePswd(User user);

    CommonDto<User> getById(Integer id);

    CommonDto<List<User>> queryAll();
}
