package com.take.takeDemo.Controller;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.take.takeDemo.Common.Util.JWT.JWTUtils;
import com.take.takeDemo.Common.Util.Msg.Msg;
import com.take.takeDemo.Entity.Goods;
import com.take.takeDemo.Entity.GoodsPlace;
import com.take.takeDemo.Entity.GoodsType;
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
    public Msg insertGoods(@RequestBody Goods goods,@RequestHeader(value = "token") String token) {
        DecodedJWT verify = JWTUtils.verify(token);
        String userId = verify.getClaim("userId").asString();
        goods.setUserId(userId);

        GoodsPlace goodsPlace = new GoodsPlace();
        goodsPlace.setPlaceName(goods.getGoodsPlace());
        goodsPlace.setUserId(userId);
        GoodsType goodsType = new GoodsType();
        goodsType.setTypeName(goods.getGoodsType());
        goodsType.setUserId(userId);

        if(goodsService.findGoodsPlace(goodsPlace)==null){
            goodsService.insertGoodsPlace(goodsPlace);
            goods.setGoodsPlace(goodsService.findGoodsPlace(goodsPlace).toString());
        }else{
            goods.setGoodsPlace(goodsService.findGoodsPlace(goodsPlace).toString());
        }
        if(goodsService.findGoodsType(goodsType)==null){
            goodsService.insertGoodsType(goodsType);
            goods.setGoodsType(goodsService.findGoodsType(goodsType).toString());
        }else{
            goods.setGoodsType(goodsService.findGoodsType(goodsType).toString());
        }

        Integer artists = goodsService.insertGoods(goods);
        return returnMsgService.returnMsg(artists);
    }


    @RequestMapping(value = "/findallgoodstype", method = RequestMethod.POST)
    @ResponseBody
    public Msg findallgoodstype(@RequestHeader(value = "token") String token) {
        DecodedJWT verify = JWTUtils.verify(token);
        String userId = verify.getClaim("userId").asString();
        System.out.println(userId);
        List<String> goodstype = goodsService.findAllGoodsType(userId);
        return returnMsgService.returnMsg(goodstype);
    }

    @RequestMapping(value = "/findallgoodsplace", method = RequestMethod.POST)
    @ResponseBody
    public Msg findallgoodsplace(@RequestHeader(value = "token") String token) {
        DecodedJWT verify = JWTUtils.verify(token);
        String userId = verify.getClaim("userId").asString();
        List<String> goodsplace = goodsService.findAllGoodsPlace(userId);
        return returnMsgService.returnMsg(goodsplace);
    }

    @RequestMapping(value = "/deleteGoods", method = RequestMethod.POST)
    @ResponseBody
    public Msg deleteGoods(@RequestBody String[] goodsIdList) {
        int deleteGoods = goodsService.deleteGoods(goodsIdList);
        return returnMsgService.returnMsg(deleteGoods);
    }

    @RequestMapping(value = "/selectLikeGoods", method = RequestMethod.POST)
    @ResponseBody
    public Msg selectLikeGoods(@RequestBody Goods goods,@RequestHeader(value = "token") String token) {
        DecodedJWT verify = JWTUtils.verify(token);
        String userId = verify.getClaim("userId").asString();
        goods.setUserId(userId);
        return returnMsgService.returnMsg(goodsService.selectLikeGoods(goods));
    }

    //测试用请求
    @RequestMapping(value = "/okToken", method = RequestMethod.POST)
    @ResponseBody
    public Msg okToken() {
        return returnMsgService.returnMsg("ok");
    }



}
