package com.taotao.service;

import com.taotao.pojo.PictureResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Description 图片处理的服务类
 * @Author: liuXuyang
 * @studentNo 15130110024
 * @Emailaddress 1187697635@qq.com
 * @Date: 2018/5/3 09:06
 */
public interface FTPImgService {

    public PictureResult uploadFile(MultipartFile uploadFile);
}
