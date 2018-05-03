package com.taotao.service.impl;

import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.pojo.TreeNode;
import com.taotao.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author: liuXuyang
 * @studentNo 15130110024
 * @Emailaddress 1187697635@qq.com
 * @Date: 2018/5/2 10:40
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private TbItemCatMapper tbItemCatMapper;

    @Override
    public List<TreeNode> getItemCatList(long parentId) {

        TbItemCatExample example = new TbItemCatExample();
        //设置查询条件
        TbItemCatExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);

        List<TbItemCat> list = tbItemCatMapper.selectByExample(example);
        List<TreeNode> treeNodes = new ArrayList<>();
        list.forEach(tbItemCat -> {
            TreeNode node= new TreeNode(tbItemCat.getId(),tbItemCat.getName(),tbItemCat.getIsParent()?"closed":"open");
            treeNodes.add(node);
        });
        return treeNodes;
    }
}
