package com.take.takeDemo;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
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
		//eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.
		// eyJ1c2VyTmFtZSI6InhpYW9odWEiLCJleHAiOjE2MTA3ODkwMjgsInVzZXJJZCI6MjF9.
		// IyA8lnNQ8wjnVCYPF6NeawSyp3a205hn5gWJPouvqhw
	}

	@Test
	public void test(){
		//创建验证对象
		JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("!@WHL@!")).build();
		//获取token信息
		DecodedJWT verify = jwtVerifier.verify("");
		//打印信息
		System.out.println(verify.getClaim("userId").asInt());
		System.out.println(verify.getClaim("userName").asString());
		System.out.println("过期时间："+verify.getExpiresAt());

		//算法不匹配异常 AlgorithmMismatchException 如：HMAC256-HMAC384
		//签名不一致异常 SignatureVerificationException
		//令牌过期异常 TokenExpiredException
		//失效的payload异常 InvalidClaimException
	}



}
