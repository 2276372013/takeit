package com.take.takeDemo.Service.impl;

import com.take.takeDemo.Dao.FriendsDao;
import com.take.takeDemo.Entity.Friends;
import com.take.takeDemo.Service.FriendsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FriendsServiceImpl implements FriendsService {

    @Autowired
    private FriendsDao friendsDao;

    @Override
    public List<Friends> findAll() {
        return friendsDao.findAll();
    }

    @Override
    public Integer insertField(Friends friends) {
        return friendsDao.insertField(friends);
    }
}
