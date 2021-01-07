package com.take.takeDemo.Controller;

import com.take.takeDemo.Entity.Users;
import com.take.takeDemo.Entity.Msg;
import com.take.takeDemo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description: no
 * @Author: whl
 * @Date: 2020/12/11 14:55 pm
 * @Version: 1.0.0
 */

@RestController
@CrossOrigin
public class UsersLoginController {

    @Autowired
    private UserService userService;

    @Autowired
    Msg<Users> msgLogin;

    @PostMapping("/login")
    @ResponseBody
    public Msg<Boolean> login(@RequestBody Users user) {
        System.out.println(user);
        Msg<Boolean> msgLogin = new Msg<Boolean>();
        Boolean n = userService.findByName(user.getUserName(),user.getUserPassword());
        msgLogin.setStatus(200);
        msgLogin.setMsg(user.getUserName());
        msgLogin.setData(n);
        return msgLogin;
    }

    @PostMapping("/updatePassword")
    @ResponseBody
    public Msg<Users> updatePassword(@RequestBody Users user) {
        Integer users = userService.updateById(user);
        msgLogin.setStatus(400);
        msgLogin.setMsg(user.getUserName());
        return msgLogin;
    }

    @PostMapping("/insertUser")
    @ResponseBody
    public Msg<Users> insertUser(@RequestBody Users user) {
        Integer users = userService.insertUser(user);
        msgLogin.setStatus(400);
        msgLogin.setMsg(user.getUserName());
        return msgLogin;
    }
}
