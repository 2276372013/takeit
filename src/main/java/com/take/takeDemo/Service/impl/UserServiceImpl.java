package com.take.takeDemo.Service.impl;

import com.take.takeDemo.Common.Util.MD5Util;
import com.take.takeDemo.Dao.UserDao;
import com.take.takeDemo.Entity.Users;
import com.take.takeDemo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
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


    @Autowired
    private JavaMailSender mailSender;

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

    private static final String SENDER = "2276372013@qq.com";

    @Override
    public void sendSimpleMailMessge(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(SENDER);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
//		try {
        mailSender.send(message);
//		} catch (Exception e) {
//			System.out.println("发送简单邮件时发生异常!"+e);
//		}
    }

    @Override
    public int updateUserPassword(String passWord, String email) {
        return userDao.updateUserPassword(passWord, email);
    }
}
