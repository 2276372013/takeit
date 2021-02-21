package com.take.takeDemo.Entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Data
@Component
public class Goods {
    private String goodsId;//'物品Id'
    private String goodsName;//'物品名称'
    private String userId;//'属于'
    private String goodsPlace;//'放置位置'
    private String goodsPublic;//'公开权限'
    private String goodsCode;//'物品分享代码'
    private Date saveTimes;//'存放多久'
    private Date placeTime;//'放置时间'
    private Date takeTime;//'拿走时间'
    private String goodsType;//'标签种类'
    private String frequency;//'操作频率'
    private String goodsPhoto;//'物品照片
    private String goodsDescribe;//'物品描述'
    private String typeName;//标签描述
}
