package com.take.takeDemo.Service.impl;

import com.take.takeDemo.Common.Util.MD5.MD5Util;
import com.take.takeDemo.Dao.UserDao;
import com.take.takeDemo.Entity.Users;
import com.take.takeDemo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

/**
 * @Description: no
 * @Author: whl
 * @Date: 2020/12/11 14:55 pm
 * @Version: 1.0.0
 */

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private MD5Util md5Util;

    @Autowired
    private JavaMailSender mailSender;

    private static final String SENDER = "2276372013@qq.com";

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Users findByName(Users user) {
        Users users = userDao.findByName(user.getUserName());
        if(DM5(user.getUserName(),user.getUserPassword(),users)){
            return users;
        }
        return null;
    }

    @Override
    public Users findByName(String userName) {
        return  userDao.findByName(userName);
    }

    @Override
    public Integer updataUser(Users user) {
        user.setUserPassword(MD5(user));
        return userDao.updataUser(user);
    }

    @Override
    public Integer insertUser(Users user) {
        System.out.println(user.getUserBirth());
        user.setUserPassword(MD5(user));
        return userDao.insertUser(user);
    }

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
    public Integer updateUserPassword(Users user) {
        return userDao.updateUserPassword(user.getUserName(), MD5(user));
    }

    public String MD5(Users user){
        String jiami = null;
        try {
            jiami = md5Util.md5(user.getUserPassword(),user.getUserName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jiami;
    }

    public boolean DM5(String userName, String userPassword,Users user){
        Boolean jiemi = null;
        try {
            jiemi = md5Util.verify(userPassword,userName,user.getUserPassword());
            if(jiemi.equals(true)){
                return true;
            }
        } catch (Exception e) {
//            e.printStackTrace();解开就报
            throw new RuntimeException("登录失败~~");
        }
        return false;
    }
}
