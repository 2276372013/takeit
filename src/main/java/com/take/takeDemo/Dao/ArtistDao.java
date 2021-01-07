package com.take.takeDemo.Dao;

import com.take.takeDemo.Entity.Artist;
import com.take.takeDemo.Entity.Field;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArtistDao {
    List<Artist>  findAll();
    Integer insertArtist(Artist artist);
}
