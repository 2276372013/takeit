package com.take.takeDemo.Controller;

import com.take.takeDemo.Entity.Friends;
import com.take.takeDemo.Common.Util.Msg.Msg;
import com.take.takeDemo.Entity.Users;
import com.take.takeDemo.Service.FriendsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class FriendsController {

    @Autowired
    private FriendsService friendsService;

    @Autowired
    Msg<Users> msgLogin;

    @PostMapping("/finallfield")
    @ResponseBody
    public List<Friends> findAll() {
        return friendsService.findAll();
    }

    @PostMapping("/insertfield")
    @ResponseBody
    public int insertArtist(@RequestBody Friends friends) {
        Integer fields = friendsService.insertField(friends);
        return fields;
    }

    @PostMapping("/ok")
    @ResponseBody
    public String ok() {
        return "ok";
    }

}
