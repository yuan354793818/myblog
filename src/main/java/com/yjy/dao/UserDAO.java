package com.yjy.dao;

import com.yjy.pojo.User;
import com.yjy.pojo.UserExample;
import org.springframework.stereotype.Repository;

/**
 * UserDAO继承基类
 */
@Repository
public interface UserDAO extends MyBatisBaseDao<User, Integer, UserExample> {
}