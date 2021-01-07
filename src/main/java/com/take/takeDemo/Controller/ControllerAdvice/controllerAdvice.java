package com.take.takeDemo.Controller.ControllerAdvice;

import com.take.takeDemo.Entity.Msg;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @Description: no
 * @Author: whl
 * @Date: 2020/12/11 14:55 pm
 * @Version: 1.0.0
 */

@ControllerAdvice
public class controllerAdvice {
	
	@ExceptionHandler({ DuplicateKeyException.class })
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public Msg<String> duplicateRegister(Exception e) {
		Msg<String> msg = new Msg<>();
		msg.setStatus(0);
		msg.setData("用户已被注册");
		msg.setError(e.getMessage());
		return msg;
	}

	@ExceptionHandler({ Exception.class })
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public Msg<String> myMsg(Exception e) {
		Msg<String> msg = new Msg<>();
		msg.setStatus(0);
		msg.setData("请求失败");
		msg.setError(e.getMessage());
		return msg;
	}

}
