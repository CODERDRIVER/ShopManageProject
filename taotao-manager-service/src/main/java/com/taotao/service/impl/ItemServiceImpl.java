package com.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.EasyUIDatagripResult;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Description
 * @Author: liuXuyang
 * @studentNo 15130110024
 * @Emailaddress 1187697635@qq.com
 * @Date: 2018/4/30 15:38
 */
@Service
public class ItemServiceImpl implements ItemService{


    @Autowired
    private TbItemMapper itemMapper;

    @Override
    public TbItem findItemById(long id) {
       TbItem item = itemMapper.selectByPrimaryKey(id);
       return item;
    }

    @Override
    public EasyUIDatagripResult findAllItems(int page, int rows) {
        EasyUIDatagripResult easyUIDatagripResult = new EasyUIDatagripResult();
        TbItemExample example = new TbItemExample();
        PageHelper.startPage(page,rows);
        List<TbItem> list = itemMapper.selectByExample(example);
        PageInfo<TbItem> pageInfo = new PageInfo<>(list);
        easyUIDatagripResult.setTotal(pageInfo.getTotal());
        easyUIDatagripResult.setRows(list);
        return easyUIDatagripResult;
    }
}
