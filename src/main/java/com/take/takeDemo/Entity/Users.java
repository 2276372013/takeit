package com.take.takeDemo.Entity;

import lombok.Data;

import java.util.Date;

/**
 * @Description: no
 * @Author: whl
 * @Date: 2020/12/11 14:55 pm
 * @Version: 1.0.0
 */

@Data
public class Users {
    private Integer userId;
    private String userName;
    private String userPassword;
    private String userEmail;
    private String userCall;
    private String userSex;
    private Date userBirth;
    private String userLevel;
}
