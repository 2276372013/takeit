package com.take.takeDemo.Dao;

import com.take.takeDemo.Entity.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Description: no
 * @Author: whl
 * @Date: 2020/12/11 14:55 pm
 * @Version: 1.0.0
 */

@Mapper
@Repository
public interface UserDao {
    Users findByName(@Param("user_name") String user_name);
    Integer updataUser(Users user);
    Integer insertUser(Users user);
    Integer updateUserPassword(String username, String password);
}
