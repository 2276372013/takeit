package com.take.takeDemo.Controller;

import com.take.takeDemo.Entity.Goods;
import com.take.takeDemo.Service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @PostMapping("/finallartist")
    @ResponseBody
    public List<Goods> findAll() {
        return goodsService.findAll();
    }

    @PostMapping("/insertartist")
    @ResponseBody
    public int insertArtist(@RequestBody Goods goods) {
        Integer artists = goodsService.insertArtist(goods);
        return artists;
    }
}
