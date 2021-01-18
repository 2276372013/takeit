package com.take.takeDemo.Controller.AOP;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect // 切面注解
@Component // 构成
public class loginAspect {

	// 设置在LoginController的login方法的切点
//	@Pointcut("execution(public * com.take.takeDemo.Controller.UsersController.login(..))")
	@Pointcut("execution(public * com.take.takeDemo.Controller.*.*(..))")
	public void action() {// 切点映射，命名不规定
		System.out.println("hello");
	}

	 //在本类的login执行之前
	@Before("action()")
	public void beforeLogin() {
		System.out.println("before");
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
