package com.take.takeDemo.Entity;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @Description: no
 * @Author: whl
 * @Date: 2020/12/11 14:55 pm
 * @Version: 1.0.0
 */

@Data
@Component
public class Msg<T> {

	private int status;
	private T data;
	private String error;
	private String msg;
	private String token;

//	public String getToken() {
//		return token;
//	}
//
//	public void setToken(Object object) {
//		this.token = (String) object;
//	}

}
