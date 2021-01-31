package com.take.takeDemo.Service.impl;

import com.take.takeDemo.Common.Util.JWT.JWTUtils;
import com.take.takeDemo.Common.Util.Msg.Msg;
import com.take.takeDemo.Entity.Users;
import com.take.takeDemo.Service.ReturnMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ReturnMsgServiceImpl implements ReturnMsgService {

    @Autowired
    Msg<Object> msg;

    @Override
    public Msg returnMsg(Object data) {
        msg.setStatus(200);
        msg.setMsg("success");
        msg.setError("No have");
        msg.setData(data);
        return msg;
    }

    @Override
    public String setToken(Users user) {
        Map<String,String> payload = new HashMap<>();
        payload.put("userName",user.getUserName());
        payload.put("userId",user.getUserId().toString());
        String token = JWTUtils.getToken(payload);
        return token;
    }


}
