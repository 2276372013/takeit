package com.take.takeDemo.Service.impl;

import com.take.takeDemo.Dao.ArtistDao;
import com.take.takeDemo.Entity.Artist;
import com.take.takeDemo.Service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistServiceImpl implements ArtistService {

    @Autowired
    private ArtistDao artistDao;

    @Override
    public List<Artist> findAll() {
        return artistDao.findAll();
    }

    @Override
    public Integer insertArtist(Artist artist) {
        return artistDao.insertArtist(artist);
    }
}
