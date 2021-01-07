package com.take.takeDemo.Common.Pager;

import java.util.List;
import org.springframework.stereotype.Component;
import com.github.pagehelper.PageInfo;
import com.take.takeDemo.Entity.Pager;


import java.util.List;

/**
 * @Description: no
 * @Author: whl
 * @Date: 2020/12/11 14:55 pm
 * @Version: 1.0.0
 */

@Component
public class Paging<T> {

	public Pager<T> setingPager(Pager<T> pager,List<T> list) {
        //PageHelper.startPage(pager.getPageNum(), pager.getPageSize());
		pager.setList(list);
		PageInfo<T> pageInfo = new PageInfo<T>(pager.getList());
		pager.setTotal(pageInfo.getTotal());
		pager.setPages(pageInfo.getPages());
		return pager;
	}
}
