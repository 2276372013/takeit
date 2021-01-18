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
    Integer updateById(Users user);
    Integer insertUser (Users user);
//    public void sendSimpleMailMessge(String to, String subject, String content);
    public int updateUserPassword(String passWord, String email);
}
