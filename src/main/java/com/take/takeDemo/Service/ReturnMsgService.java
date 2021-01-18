package com.take.takeDemo.Service;

import com.take.takeDemo.Entity.Msg;
import com.take.takeDemo.Entity.Users;
import org.springframework.stereotype.Service;

@Service
public interface ReturnMsgService<T> {
    Msg<T> returnMsg(T data);
    String setToken(Users user);
}
