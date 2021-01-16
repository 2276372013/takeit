package com.take.takeDemo.Controller;

import com.take.takeDemo.Entity.Users;
import com.take.takeDemo.Entity.Msg;
import com.take.takeDemo.Service.ReturnMsgService;
import com.take.takeDemo.Service.UserService;
import com.take.takeDemo.Service.impl.ReturnMsgServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

/**
 * @Description: no
 * @Author: whl
 * @Date: 2020/12/11 14:55 pm
 * @Version: 1.0.0
 */

@RestController
@CrossOrigin(origins= { "http://localhost:4200", "null" })
public class UsersController {

    @Autowired
    private UserService userService;

    @Autowired
    Msg<Users> msgLogin;

    @Autowired
    ReturnMsgServiceImpl returnMsgService;

    String securityCode;

    @PostMapping("/login")
    @ResponseBody
    public Msg<Boolean> login(@RequestBody Users user) {
        System.out.println(user);
        Boolean n = userService.findByName(user.getUserName(),user.getUserPassword());
        return returnMsgService.returnMsg(n);
    }

    @PostMapping("/updatePassword")
    @ResponseBody
    public Msg<Users> updatePassword(@RequestBody Users user) {
        Integer users = userService.updateById(user);
        return returnMsgService.returnMsg(users);
    }

    @PostMapping("/insertUser")
    @ResponseBody
    public Msg<Users> insertUser(@RequestBody Users user) {
        Integer users = userService.insertUser(user);
        return returnMsgService.returnMsg(users);
    }

    @PostMapping("/updataUserPassword")
    @ResponseBody
    public Msg<Users> updataUserPassword(@RequestBody Users user) {
        Integer users = userService.insertUser(user);
        return returnMsgService.returnMsg(users);
    }

//    @RequestMapping(value = "/securityCode", method = RequestMethod.POST)
//    @ResponseBody
//    public Msg<Integer> securityCode(@RequestBody Users user) {
//        securityCode = String.format("%04d",new Random().nextInt(9999));
//        userService.sendSimpleMailMessge(user.getUserEmail(), "验证码","您正在使用邮箱验证码修改账户密码功能，该验证码仅用于修改密码，请勿泄露给他人使用。" +"验证码："+securityCode);
//        userService.setData(1);
//        userService.setStatus(1);
//        return msgEmail;
//    }
}
