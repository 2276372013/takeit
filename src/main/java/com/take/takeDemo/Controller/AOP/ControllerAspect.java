package com.take.takeDemo.Controller.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import lombok.extern.slf4j.Slf4j;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Date;
@Slf4j
@Aspect // 切面注解
@Component // 构成
public class ControllerAspect {

	/**
	 * 定义切入点，切入点为com.example.aop下的所有函数
	 */
	@Pointcut("execution(public * com.take.takeDemo.Controller.*.*(..))")
	public void webLog(){}

	/**
	 * 前置通知：在连接点之前执行的通知
	 * @param joinPoint
	 * @throws Throwable
	 */
	@Before("webLog()")
	public void doBefore(JoinPoint joinPoint) throws Throwable {
		// 接收到请求，记录请求内容
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
//		HttpServletResponse response = attributes.getResponse();
		// 记录下请求内容
		log.info("请求request时间: " + new Date());
		log.info("请求URL : " + request.getRequestURL().toString());
		log.info("请求方法：" + request.getMethod());
		log.info("访问人IP : " + request.getRemoteAddr());
		log.info("请求的类名：" + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
		log.info("携带数据（token）ARGS : " + Arrays.toString(joinPoint.getArgs()));
	}

	@AfterReturning(returning = "ret",pointcut = "webLog()")
	public void doAfterReturning(Object ret) throws Throwable {
		// 处理完请求，返回内容
		log.info("响应数据: " + ret);
	}
}
