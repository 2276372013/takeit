package com.take.takeDemo.Service.impl;

import com.take.takeDemo.Entity.Msg;
import com.take.takeDemo.Service.ReturnMsgService;
import org.springframework.stereotype.Service;

@Service
public class ReturnMsgServiceImpl implements ReturnMsgService {

    @Override
    public Msg returnMsg(Object data) {
        Msg<Object> msgLogin = new Msg<Object>();
        msgLogin.setStatus(200);
        msgLogin.setMsg("success");
        msgLogin.setData(data);
        return msgLogin;
    }
}
