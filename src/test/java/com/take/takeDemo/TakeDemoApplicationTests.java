package com.take.takeDemo;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.HashMap;
import java.util.function.ObjIntConsumer;

/*
@SpringBootTest
*/
class TakeDemoApplicationTests {

	@Test
	void contextLoads() {
		HashMap<String, Object> map = new HashMap<>();

		Calendar instance = Calendar.getInstance();
		instance.add(Calendar.SECOND,20);

		String token = JWT.create()
				.withHeader(map) //header
		        .withClaim("userId",21) //payload
				.withClaim("userName","xiaohua")
				.withExpiresAt(instance.getTime())//制定令牌过期时间
				.sign(Algorithm.HMAC256("!@WHL@!"));//

		System.out.println(token);
	}

}
