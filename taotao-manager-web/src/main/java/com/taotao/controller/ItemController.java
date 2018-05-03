package com.taotao.controller;

import com.github.pagehelper.PageHelper;
import com.taotao.pojo.EasyUIDatagripResult;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.pojo.TreeNode;
import com.taotao.service.ItemCatService;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description
 * @Author: liuXuyang
 * @studentNo 15130110024
 * @Emailaddress 1187697635@qq.com
 * @Date: 2018/4/30 19:23
 */
@Controller
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;
    @Autowired
    private ItemCatService itemCatService;

    /**
     * 根据itemId查询Item
     * @param itemId
     * @return
     */
    @RequestMapping("/{itemId}")
    @ResponseBody
    public TbItem findItemById(@PathVariable("itemId")long itemId)
    {
        TbItem item = itemService.findItemById(itemId);
        return item;
    }

    /**
     * item列表查询
     * url : item/url
     * http://localhost:8080/item/list?page=1&rows=30
     * 返回值 Easyui 中 datagrid 控件要求的数据格式为: {total:”2”,rows:[{“id”:”1”,”name”,”张三”},{“id”:”2”,”name”,”李四”}]}
     */
    @RequestMapping("/list")
    @ResponseBody
    public EasyUIDatagripResult findAllItems(int page,int rows)
    {
        return itemService.findAllItems(page,rows);
    }

    /**
     * /item/cat/list
     * 查询所有商品分类
     */
    @RequestMapping(value = "/cat/list",method = RequestMethod.POST)
    @ResponseBody
    public List<TreeNode> getItemCatList(@RequestParam(value = "id",defaultValue = "0") long parentId)
    {
        return itemCatService.getItemCatList(parentId);
    }
}
