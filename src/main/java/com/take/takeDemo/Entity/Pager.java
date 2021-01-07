package com.take.takeDemo.Entity;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Description: no
 * @Author: whl
 * @Date: 2020/12/11 14:55 pm
 * @Version: 1.0.0
 */

@Data
public class Pager<T> {
	
	//第几页
    @NotNull
    private int pageNum;
    //每页多少
    private int pageSize;
    //数据总数
    private long total;
    //共分多少页
    private int pages;
    //数据
    private List<T> list;

}

