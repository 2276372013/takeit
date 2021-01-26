package com.take.takeDemo.Controller;

import com.take.takeDemo.Common.Util.Msg.Msg;
import com.take.takeDemo.Common.Util.VerifyCode.IVerifyCodeGen;
import com.take.takeDemo.Common.Util.VerifyCode.SimpleCharVerifyCodeGenImpl;
import com.take.takeDemo.Common.Util.VerifyCode.VerifyCode;
import com.take.takeDemo.Entity.Users;
import com.take.takeDemo.Service.IRedisService;
import com.take.takeDemo.Service.UserService;
import com.take.takeDemo.Service.impl.ReturnMsgServiceImpl;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

/**
 * @Description: no
 * @Author: whl
 * @Date: 2020/12/11 14:55 pm
 * @Version: 1.0.0
 */
@RequestMapping("/user")
@RestController
@Slf4j
public class UsersController {

    @Autowired
    private UserService userService;

    @Autowired
    Msg<Users> msgLogin;

    @Autowired
    ReturnMsgServiceImpl returnMsgService;

    @Autowired
    private IRedisService redisService;

    @PostMapping(path = "/login", name = "用户登陆")
    @ResponseBody
    public Msg<Boolean> login(@RequestBody Users user, HttpServletRequest request) {

        log.info("当前token为：[{}]", user.getUserName(), "登陆系统。");
        Boolean n = userService.findByName(user.getUserName(), user.getUserPassword());
        this.redisService.setRedisString(user.getUserName()+"token",returnMsgService.setToken(user));
        Msg msg = returnMsgService.returnMsg(n);
        msg.setToken(redisService.getRedisString(user.getUserName()+"token").toString());
        return msg;
    }

    @PostMapping("/updataUser")
    @ResponseBody
    public Msg<Users> updatePassword(@RequestBody Users user) {
        Integer users = userService.updataUser(user);
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
    public Msg<Integer> updataUserPassword(@RequestBody Users user) {
        if (user.getUserCall().equals(redisService.getRedisString(user.getUserEmail()+"securityCode"))) {
            Integer users = userService.updateUserPassword(user);
            return returnMsgService.returnMsg(users);
        }
        return returnMsgService.returnMsg("密码修改失败");
    }

    @RequestMapping(value = "/securityCode", method = RequestMethod.POST)
    @ResponseBody
    public void securityCode(@RequestBody String Email) {
        this.redisService.setRedisString(Email+"securityCode",String.format("%04d", new Random().nextInt(9999)));
        userService.sendSimpleMailMessge(Email,
                "验证码",
                "您正在使用邮箱验证码修改账户密码功能，该验证码仅用于修改密码，请勿泄露给他人使用。验证码：" + redisService.getRedisString(Email+"securityCode"));
    }

    @ApiOperation(value = "验证码")
    @GetMapping("/verifyCode")
    public void verifyCode(HttpServletRequest request, HttpServletResponse response) {
        IVerifyCodeGen iVerifyCodeGen = new SimpleCharVerifyCodeGenImpl();
        try {
            //设置长宽
            VerifyCode verifyCode = iVerifyCodeGen.generate(80, 28);
            String code = verifyCode.getCode();
            log.info(code);
            //将VerifyCode绑定session
            request.getSession().setAttribute("VerifyCode", code);
            //设置响应头
            response.setHeader("Pragma", "no-cache");
            //设置响应头
            response.setHeader("Cache-Control", "no-cache");
            //在代理服务器端防止缓冲
            response.setDateHeader("Expires", 0);
            //设置响应内容类型
            response.setContentType("image/jpeg");
            response.getOutputStream().write(verifyCode.getImgBytes());
            response.getOutputStream().flush();
        } catch (IOException e) {
            log.info("", e);
        }
    }
}
