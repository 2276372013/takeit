package com.take.takeDemo.Service;

import com.take.takeDemo.Entity.Artist;
import com.take.takeDemo.Entity.Field;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FieldService {
    List<Field>  findAll();
    Integer insertField(Field field);
}
