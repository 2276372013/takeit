package com.take.takeDemo.Controller;

import com.take.takeDemo.Entity.Goods;
import com.take.takeDemo.Service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RequestMapping("/goods")
@RestController
@CrossOrigin
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @PostMapping("/finallGoods")
    @ResponseBody
    public List<Goods> findAll() {
        return goodsService.findAll();
    }

    @PostMapping("/insertGoods")
    @ResponseBody
    public int insertArtist(@RequestBody Goods goods) {
        Integer artists = goodsService.insertGoods(goods);
        return artists;
    }
}
