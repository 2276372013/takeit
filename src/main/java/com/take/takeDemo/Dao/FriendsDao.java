package com.take.takeDemo.Dao;

import com.take.takeDemo.Entity.Friends;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FriendsDao {
    List<Friends>  findAll();
    Integer insertField(Friends friends);
}
