package com.take.takeDemo.Common.Util;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

@Component
public class MD5Util {

// 带秘钥加密
public static String md5(String text, String key) throws Exception {
    // 加密后的字符串
    String md5str = DigestUtils.md5Hex(text + key);
//    System.out.println("MD5加密后的字符串为:" + md5str);
    return md5str;
}

    // 不带秘钥加密
    public static String md52(String text) throws Exception {
        // 加密后的字符串
        String md5str = DigestUtils.md5Hex(text);
//        System.out.println("MD52加密后的字符串为:" + md5str + "\t长度：" + md5str.length());
        return md5str;
    }

    /**
     * MD5验证方法
     *
     * text明文
     *  key密钥
     *  md5密文
     */
    // 根据传入的密钥进行验证
    public static boolean verify(String text, String key, String md5) throws Exception {
        String md5str = md5(text, key);
        if (md5str.equalsIgnoreCase(md5)) {
//            System.out.println("MD5验证通过");
            return true;
        }
        return false;
    }

}
