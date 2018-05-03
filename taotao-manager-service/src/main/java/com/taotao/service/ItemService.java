package com.taotao.service;

import com.taotao.pojo.EasyUIDatagripResult;
import com.taotao.pojo.TbItem;

/**
 * @Description
 * @Author: liuXuyang
 * @studentNo 15130110024
 * @Emailaddress 1187697635@qq.com
 * @Date: 2018/4/30 15:35
 */
public interface ItemService {

    //根据商品id查询商品列表
    public TbItem findItemById(long id);

    //返回某一页中所有item

    /**
     *
     * @param page 当前页
     * @param rows  总行数
     * @return
     */
    public EasyUIDatagripResult findAllItems(int page,int rows);


}
