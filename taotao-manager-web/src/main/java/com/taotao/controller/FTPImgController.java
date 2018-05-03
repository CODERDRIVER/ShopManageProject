package com.taotao.controller;

import com.taotao.pojo.PictureResult;
import com.taotao.service.FTPImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Description 图片上传前端Controller
 * @Author: liuXuyang
 * @studentNo 15130110024
 * @Emailaddress 1187697635@qq.com
 * @Date: 2018/5/3 09:50
 */
@Controller
public class FTPImgController {

    @Autowired
    private FTPImgService ftpImgService;

    @RequestMapping("/pic/upload")
    @ResponseBody
    public PictureResult upload(MultipartFile uploadFile)
    {
        PictureResult pictureResult = ftpImgService.uploadFile(uploadFile);
        System.out.println(pictureResult.getMessage()+pictureResult.getUrl());
        return pictureResult;
    }
}
