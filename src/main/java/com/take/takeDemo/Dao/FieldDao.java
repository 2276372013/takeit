package com.take.takeDemo.Dao;

import com.take.takeDemo.Entity.Artist;
import com.take.takeDemo.Entity.Field;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FieldDao {
    List<Field>  findAll();
    Integer insertField(Field field);
}
