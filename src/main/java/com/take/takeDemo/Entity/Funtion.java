package com.take.takeDemo.Entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Funtion {
    private Integer actionId;
    private Integer actionName;
    private Integer actionPath;
    private Integer actionMethod;
}
