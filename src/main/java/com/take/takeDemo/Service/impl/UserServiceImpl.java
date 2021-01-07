package com.take.takeDemo.Service.impl;

import com.take.takeDemo.Common.Util.MD5Util;
import com.take.takeDemo.Dao.UserDao;
import com.take.takeDemo.Entity.Users;
import com.take.takeDemo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

/**
 * @Description: no
 * @Author: whl
 * @Date: 2020/12/11 14:55 pm
 * @Version: 1.0.0
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private MD5Util md5Util;

    @Override
    public Boolean findByName(String userName, String userPassword) {
        Users user = userDao.findByName(userName);
        Boolean jiemi = null;
        try {
            jiemi = md5Util.verify(userPassword,userName,user.getUserPassword());
            if(jiemi.equals(true)){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Integer updateById(Users user) {
        return userDao.updateById(user);
    }

    @Override
    public Integer insertUser(Users user) {
        String jiami = null;
        try {
            jiami = md5Util.md5(user.getUserPassword(),user.getUserName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        user.setUserPassword(jiami);
        return userDao.insertUser(user);
    }
}
