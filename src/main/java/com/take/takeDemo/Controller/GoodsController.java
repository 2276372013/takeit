package com.take.takeDemo.Controller;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.take.takeDemo.Common.Util.JWT.JWTUtils;
import com.take.takeDemo.Common.Util.Msg.Msg;
import com.take.takeDemo.Entity.Goods;
import com.take.takeDemo.Service.GoodsService;
import com.take.takeDemo.Service.impl.ReturnMsgServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RequestMapping("/goods")
@RestController
@CrossOrigin
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    ReturnMsgServiceImpl returnMsgService;

    @PostMapping("/finallGoods")
    @ResponseBody
    public Msg findAll(@RequestHeader(value = "token") String token) {
        DecodedJWT verify = JWTUtils.verify(token);
        String userId = verify.getClaim("userId").asString();
        return returnMsgService.returnMsg(goodsService.findAll(userId));
    }

    @PostMapping("/insertGoods")
    @ResponseBody
    public Msg insertArtist(@RequestBody Goods goods) {
        Integer artists = goodsService.insertGoods(goods);
        return returnMsgService.returnMsg(artists);
    }


}
