package com.take.takeDemo.Common.InterfaceDIY;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;
import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface Ontime {
    @AliasFor(annotation = Component.class)
    String value();
    String comment();
    String cron();
}
