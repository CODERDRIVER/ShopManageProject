package com.taotao.service;


import com.taotao.pojo.TreeNode;

import java.util.List;

/**
 * @Description item分类
 * @Author: liuXuyang
 * @studentNo 15130110024
 * @Emailaddress 1187697635@qq.com
 * @Date: 2018/5/2 10:38
 */
public interface ItemCatService {

    /**
     * 根据parentId查询分类
     */
    public List<TreeNode> getItemCatList(long parentId);
}
