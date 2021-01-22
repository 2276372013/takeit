package com.take.takeDemo.Service;

import com.take.takeDemo.Dao.UserDao;
import com.take.takeDemo.Entity.Users;
import org.springframework.stereotype.Service;

/**
 * @Description: no
 * @Author: whl
 * @Date: 2020/12/11 14:55 pm
 * @Version: 1.0.0
 */

@Service
public interface UserService {
    Boolean findByName(String userName,String userPassword);
    Integer updataUser(Users user);
    Integer insertUser (Users user);
    void sendSimpleMailMessge(String to, String subject, String content);
    Integer updateUserPassword(Users user);
}
