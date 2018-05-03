package com.taotao.service.impl;

import com.taotao.pojo.PictureResult;
import com.taotao.service.FTPImgService;
import com.taotao.util.FTPUtil;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sun.net.ftp.FtpClient;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @Description
 * @Author: liuXuyang
 * @studentNo 15130110024
 * @Emailaddress 1187697635@qq.com
 * @Date: 2018/5/3 09:09
 */
@Service
public class FTPImgServiceImpl implements FTPImgService {

    @Value("${HOSTADDRESS}")
    private String HOSTADDRESS;

    @Value("${PORT}")
    private int PORT;

    @Value("${USERNAME}")
    private String USERNAME;

    @Value("${PASSWORD}")
    private String PASSWORD;

    @Value("${BASEPATH}")
    private String BASEPATH;

    @Override
    public PictureResult uploadFile(MultipartFile uploadFile) {

        if (uploadFile==null||uploadFile.isEmpty())
        {
            return new PictureResult(1,null,"上传图片为空");
        }

        //文件的原有路径加名称
        String orginName = uploadFile.getOriginalFilename();

        //获得文件的后缀
        String ext = orginName.split("\\.")[1];

        //随机生成一个文件名称
        String name = UUID.randomUUID().toString();

        //对图片的url进行改造
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String dir = simpleDateFormat.format(date);

        String fileName = name+"."+ext;
        //上传文件
        boolean flag = FTPUtil.uploadFile(uploadFile,HOSTADDRESS,PORT,USERNAME,PASSWORD,BASEPATH,dir,fileName, FTPClient.BINARY_FILE_TYPE);
        if (!flag)
        {
            return new PictureResult(1,null,"上传失败");
        }else{
            return new PictureResult(0,BASEPATH+dir+"/"+fileName,null);
        }
    }
}
