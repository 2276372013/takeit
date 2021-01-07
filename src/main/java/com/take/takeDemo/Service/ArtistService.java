package com.take.takeDemo.Service;

import com.take.takeDemo.Entity.Artist;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ArtistService {
    List<Artist> findAll();
    Integer insertArtist(Artist artist);
}
