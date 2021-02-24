package com.take.takeDemo.Controller.AOP;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.take.takeDemo.Common.Util.JWT.JWTUtils;
import com.take.takeDemo.Entity.Goods;
import com.take.takeDemo.Service.GoodsService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;

@Slf4j// log.info
@Aspect // 切面注解
@Component // 构成
public class GoodsControllerAspect {

	@Autowired
	private GoodsService goodsService;

	// 设置在LoginController的login方法的切点
	@Pointcut("execution(public * com.take.takeDemo.Controller.GoodsController.insertGoods(..))")
	public void action() {
	    // 切点映射，命名不规定
         }

	 //在本类的login执行之前
	@Before("action()")
	public void beforeLogin(JoinPoint joinPoint) {
		// 接收到请求，记录请求内容
		ObjectMapper objectMapper = new ObjectMapper();
		Goods goods = objectMapper.convertValue(joinPoint.getArgs()[0], Goods.class);
		String typeName = goods.getGoodsType();
		String placeName = goods.getGoodsPlace();



		DecodedJWT verify = JWTUtils.verify(joinPoint.getArgs()[1].toString());
		String userId = verify.getClaim("userId").asString();

		if(goodsService.findGoodsPlace(userId,placeName) != 1){
			goodsService.insertGoodsPlace(userId,placeName);
		}
		if(goodsService.findGoodsType(userId,typeName) != 1){
			goodsService.insertGoodsType(userId,typeName);
		}

		log.info("携带数据（token）ARGS : " + Arrays.toString(joinPoint.getArgs()));
	}

	// 在本类的login执行之后执行
	@After("action()")
	public void afterLogin() {

	}

//	/**
//	 * @description  在连接点执行之后执行的通知（返回通知）
//	 */
//	@AfterReturning("BrokerAspect()")
//	public void doAfterReturningGame(){
//		System.out.println("返回通知");
//	}
//
//	/**
//	 * @description  在连接点执行之后执行的通知（异常通知）
//	 */
//	@AfterThrowing("BrokerAspect()")
//	public void doAfterThrowingGame(){
//		System.out.println("异常通知");
//	}

}
