package com.take.takeDemo.Dao;

import com.take.takeDemo.Entity.Artist;
import com.take.takeDemo.Entity.Field;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ArtistDao {
    List<Artist>  findAll();
    Integer insertArtist(Artist artist);
}
