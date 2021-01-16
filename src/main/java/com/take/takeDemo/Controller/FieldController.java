package com.take.takeDemo.Controller;

import com.take.takeDemo.Entity.Field;
import com.take.takeDemo.Entity.Msg;
import com.take.takeDemo.Entity.Users;
import com.take.takeDemo.Service.FieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class FieldController {

    @Autowired
    private FieldService fieldService;

    @Autowired
    Msg<Users> msgLogin;

    @PostMapping("/finallfield")
    @ResponseBody
    public List<Field> findAll() {
        return fieldService.findAll();
    }

    @PostMapping("/insertfield")
    @ResponseBody
    public int insertArtist(@RequestBody Field field) {
        Integer fields = fieldService.insertField(field);
        return fields;
    }
}
