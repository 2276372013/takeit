package com.take.takeDemo.Common.interceptors;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.InvalidClaimException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.take.takeDemo.Common.Util.JWT.JWTUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class JWTInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handler) throws Exception {

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "POST,GET,OPTIONS,DELETE,PATCH,PUT");
//        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Origin,X-Requested-With,x-requested-with,X-Custom-Header,Content-Type,Accept,Authorization");

        String method = request.getMethod();
        if ("OPTIONS".equalsIgnoreCase(method)){
            log.info("OPTIONS请求");
            response.setStatus(HttpServletResponse.SC_ACCEPTED);
        }

        //获取请求头中的令牌
        String token = request.getHeader("token");

//        log.info("当前token为：[{}]", token);

        Map<String, Object> map = new HashMap<>();
        try {
            JWTUtils.verify(token);//验证令牌
            return true;//放行请求
        } catch (SignatureVerificationException e) {
            log.error("签名不一致");
            map.put("msg", "签名不一致");
        } catch (TokenExpiredException e) {
            log.error("令牌过期");
            map.put("msg", "令牌过期");
        } catch (AlgorithmMismatchException e) {
            log.error("算法不匹配");
            map.put("msg", "算法不匹配");
        } catch (InvalidClaimException e) {
            log.error("失效的payload");
            map.put("msg", "失效的payload");
        } catch (Exception e) {
            log.error("token无效");
            map.put("msg", "token无效");
        }

        map.put("state", false);

        //响应到前台: 将map转为json
        String json = new ObjectMapper().writeValueAsString(map);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println(json);
        return false;
    }
}
