package com.take.takeDemo.Controller.ActionOnTime;

import com.take.takeDemo.Common.InterfaceDIY.Ontime;
import com.take.takeDemo.Service.OntimeActionService;
import org.springframework.beans.factory.annotation.Autowired;

@Ontime(value="tomorrow-expire",comment="查看明天到期物品",cron="0 0 8,20 1/1 * ?")
public class OntimeAction {
    //每天早八晚八 cron="0 0 8,20 1/1 * ?

    @Autowired
    private OntimeActionService ontimeActionService;

    public void checkExpire(){

    }

}
