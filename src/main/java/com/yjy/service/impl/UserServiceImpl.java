package com.yjy.service.impl;

import com.yjy.dao.UserDAO;
import com.yjy.dto.CommonDto;
import com.yjy.enums.CommonState;
import com.yjy.exception.CommonException;
import com.yjy.pojo.User;
import com.yjy.pojo.UserExample;
import com.yjy.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserDAO userDAO;

    public CommonDto<User>  regist(User user) {
        if (user != null) {
            if (StringUtils.isEmpty(user.getUserName())) {
                return new CommonDto(false, CommonState.NAME_NULL);
            }
            if (StringUtils.isEmpty(user.getPassword())) {
                return new CommonDto(false, CommonState.PSWD_NULL);
            }

            try {
                UserExample example=new UserExample();
                example.createCriteria().andUserNameEqualTo(user.getUserName());
                List<User> users = userDAO.selectByExample(example);
                if (users == null || users.size() == 0) {
                    user.setPassword(DigestUtils.md5DigestAsHex((user.getUserName()+user.getPassword()).getBytes()));
                    userDAO.insert(user);
                    return new CommonDto<User>(user,true,CommonState.REGIST_SUCCESS);
                }else {
                    return new CommonDto(false, CommonState.NAME_REGISTERED);
                }
            } catch (Exception e) {
                logger.error(e.getMessage(),e);
                return new CommonDto(false, CommonState.INNER_ERROR);
            }

        } else {
            return new CommonDto(false, CommonState.INPUT_NULL);
        }
    }

    public CommonDto<User> login(User user) {
        if (user != null) {
            if (StringUtils.isEmpty(user.getUserName())) {
                return new CommonDto(false, CommonState.NAME_NULL);
            }
            if (StringUtils.isEmpty(user.getPassword())) {
                return new CommonDto(false, CommonState.PSWD_NULL);
            }

            UserExample example=new UserExample();
            example.createCriteria().andUserNameEqualTo(user.getUserName());
            List<User> users = userDAO.selectByExample(example);
            if (users == null || users.size() == 0) {
                return new CommonDto(false, CommonState.USER_NOT_FOUND);
            }

            User user1 = users.get(0);
            if (user1.getPassword() != null && user1.getPassword().equals(DigestUtils.md5DigestAsHex((user.getUserName()+user.getPassword()).getBytes()))) {
                return new CommonDto<User>(user1,true, CommonState.LOGIN_SUCCESS);
            }else {
                return new CommonDto(false, CommonState.PSWD_INCORRECT);
            }
        } else {
            return new CommonDto(false, CommonState.INPUT_NULL);
        }
    }

    public CommonDto logout(User user) {
        return null;
    }

    public CommonDto updatePswd(User user) {
        return null;
    }

    public CommonDto<User> getById(Integer id) {
        if (id == null) {
            throw new CommonException("id为空");
        }
        User user = userDAO.selectByPrimaryKey(id);
        if (user!= null) {
            return new CommonDto(user,true);
        }
        return new CommonDto(false,CommonState.USER_NOT_FOUND);
    }

    public CommonDto<List<User>> queryAll() {
        List<User> users = userDAO.selectByExample(null);
        return new CommonDto<List<User>>(users,true);
    }
}
