package com.take.takeDemo.Common.Util.JWT;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import java.util.Calendar;
import java.util.Map;

public class JWTUtils {

    //密钥
    private static String SECRET = "token!@WHL@!";

    /**
     * 根据传入信息生成token
     * @param map //传入payload
     * @return 返回token
     */
    public static String getToken(Map<String, String> map) {

        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE, 7); //默认7天过期
        //创建jwt builder
        JWTCreator.Builder builder = JWT.create();

        //payload
        map.forEach((k, v) -> {

            builder.withClaim(k, v);
        });

        builder.withExpiresAt(instance.getTime());//指定令牌的过期时间
        String token = builder.sign(Algorithm.HMAC256(SECRET));//sign签名
        return token;
    }

    /**
     * 验证token 合法性
     */
    public static DecodedJWT verify(String token) {
        //如果有任何验证异常，此处都会抛出异常
        DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC256(SECRET)).build().verify(token);
        return decodedJWT;
    }

//    /**
//     * 验证token 合法性
//     */
//    public static void verify(String token) {
//        //如果有任何验证异常，此处都会抛出异常
//        DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC256(SECRET)).build().verify(token);
//    }
//    /**
//     * 获取token中的信息payload
//     */
//    public static DecodedJWT getToken(String token) {
//        DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC256(SECRET)).build().verify(token);
//        return decodedJWT;
//    }
}
