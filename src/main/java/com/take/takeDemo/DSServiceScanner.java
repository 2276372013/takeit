package com.take.takeDemo;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.condition.RequestMethodsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.Map;

@Component
@Log4j2
@Order(2)
public class DSServiceScanner implements CommandLineRunner {

    @Autowired
    private ApplicationContext applicationContext;

    @Value("${server.hostname}")
    private String serverHostname;
    @Value("${server.servlet.context-path}")
    private String serverContextPath;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Spring Boot 启动自己执行");
        System.out.println("serverHostname："+serverHostname);
        System.out.println("serverContextPath："+serverContextPath);
        //扫描接口
        this.requestMappingScanner();
    }

    private void requestMappingScanner() {
//        //获取RequestMapping注解的类
//        Map<String, Object> beans = applicationContext.getBeansWithAnnotation(RestController.class);
//        Collection<Object> values = beans.values();
//        System.out.println("values:"+values);

//        // 查询出所有发布接口表中的所有数据
//        List<Funtion> dsInterfacePublishEntities = Funtion.queryAll();

        RequestMappingHandlerMapping mapping = applicationContext.getBean(RequestMappingHandlerMapping.class);
        Map<RequestMappingInfo, HandlerMethod> map = mapping.getHandlerMethods();
        first:
        for (Map.Entry<RequestMappingInfo, HandlerMethod> m : map.entrySet()) {
            String interfaceUrl = null, interfaceCode = null, interfaceName = null, reuqestMethod = null;
            RequestMappingInfo info = m.getKey();
            System.out.println("info.getName() --- >" +  info.getName());
            System.out.println("info --- >" + info);
            PatternsRequestCondition p = info.getPatternsCondition();

            for (String url : p.getPatterns()) {
                if (!url.startsWith("/user")) {
                    continue first;
                }
                // 获取接口编码
                interfaceCode = url.substring(url.lastIndexOf("/") + 1);
                System.out.println("interfaceCode  ----->  " + interfaceCode);
                // 获取并拼接interfaceUrl
//                interfaceUrl = serverHostname + serverContextPath + url;
            }
            // 获取接口名称
            interfaceName = info.getName();
            RequestMethodsRequestCondition methodsCondition = info.getMethodsCondition();
            for (RequestMethod requestMethod : methodsCondition.getMethods()) {
                // 获取接口函数
                reuqestMethod = requestMethod.toString();
                System.out.println("reuqestMethod  ----->  " + reuqestMethod);
            }
        }
    }
}
