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

    @PostMapping("/findGoodsPasstime")
    @ResponseBody
    public Msg findGoodsPasstime(@RequestHeader(value = "token") String token) {
        DecodedJWT verify = JWTUtils.verify(token);
        String userId = verify.getClaim("userId").asString();
        return returnMsgService.returnMsg(goodsService.findGoodsPasstime(userId));

    }

    @PostMapping("/findGoodsWilltime")
    @ResponseBody
    public Msg findGoodsWilltime(@RequestHeader(value = "token") String token) {
        DecodedJWT verify = JWTUtils.verify(token);
        String userId = verify.getClaim("userId").asString();
        return returnMsgService.returnMsg(goodsService.findGoodsWilltime(userId));

    }

    @PostMapping("/insertGoods")
    @ResponseBody
    public Msg insertGoods(@RequestBody Goods goods,@RequestHeader(value = "token") String token) {
        goodsService.findInsterTypePlace(goods,token);
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

    @RequestMapping(value = "/updatePassTime/{goodsid}/{update}", method = RequestMethod.POST)
    @ResponseBody
    public Msg updatePassTime(@PathVariable("goodsid") String goodsid,@PathVariable("update") String update) {
        return returnMsgService.returnMsg(goodsService.updatePassTime(goodsid,update));
    }

    @RequestMapping(value = "/updataGoods", method = RequestMethod.POST)
    @ResponseBody
    public Msg updataGoods(@RequestBody Goods goods,@RequestHeader(value = "token") String token) {
        goodsService.findInsterTypePlace(goods,token);
        return returnMsgService.returnMsg(goodsService.updataGoods(goods));
    }

    //测试用请求
    @RequestMapping(value = "/okToken", method = RequestMethod.POST)
    @ResponseBody
    public Msg okToken() {
        return returnMsgService.returnMsg("ok");
    }


}
