package com.take.takeDemo.Service.impl;

import com.take.takeDemo.Dao.FieldDao;
import com.take.takeDemo.Entity.Field;
import com.take.takeDemo.Service.FieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FieldServiceImpl implements FieldService {

    @Autowired
    private FieldDao fieldDao;

    @Override
    public List<Field> findAll() {
        return fieldDao.findAll();
    }

    @Override
    public Integer insertField(Field field) {
        return fieldDao.insertField(field);
    }
}
