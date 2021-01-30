package com.take.takeDemo.Entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Friends {
    private Integer fieldid;
    private String fieldname;
    private String fieldadress;
    private String fieldcall;
    private String musictype;
    private String fieldtime;
    private String fieldtype;
}
