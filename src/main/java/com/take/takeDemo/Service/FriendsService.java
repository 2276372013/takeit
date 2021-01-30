package com.take.takeDemo.Service;

import com.take.takeDemo.Entity.Friends;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FriendsService {
    List<Friends>  findAll();
    Integer insertField(Friends friends);
}
