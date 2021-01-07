package com.take.takeDemo.Controller;

import com.take.takeDemo.Entity.Artist;
import com.take.takeDemo.Service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @PostMapping("/finallartist")
    @ResponseBody
    public List<Artist> findAll() {
        return artistService.findAll();
    }

    @PostMapping("/insertartist")
    @ResponseBody
    public int insertArtist(@RequestBody Artist artist) {
        Integer artists = artistService.insertArtist(artist);
        return artists;
    }
}
