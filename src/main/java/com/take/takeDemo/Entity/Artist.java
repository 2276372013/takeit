package com.take.takeDemo.Entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Artist {
    private Integer artistid;
    private String artistname;
    private String artistinformation;
    private String Careerexperience;
    private String Honorrecord;
    private String actingexperience;
}
