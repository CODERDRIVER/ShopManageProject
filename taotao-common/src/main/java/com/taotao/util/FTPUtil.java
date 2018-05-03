package com.taotao.util;

import org.apache.commons.net.ftp.FTPClient;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.file.FileSystems;

/**
 * @Description
 * @Author: liuXuyang
 * @studentNo 15130110024
 * @Emailaddress 1187697635@qq.com
 * @Date: 2018/5/3 08:43
 */
public class FTPUtil {

//    public static final String HOST = "119.23.75.180";
//    public static final int PORT = 21;
//    public static final String USER = "ftptest";
//    public static final String PASSWORD = "ftptest";
    /**
     * ftp上传文件
     * file:需要上传的文件
     * path:上传文件的路径
     *fileType 上传文件的类型
     * fileName 上传文件的名称
     */
    public static boolean uploadFile(MultipartFile file, String HOST,int PORT,String USER,String PASSWORD,String basePath,String dir, String fileName, int fileType)
    {

        //连接服务器
        FTPClient ftpClient = new FTPClient();
        InputStream fileInputStream = null;
        boolean flag = false;
        try{
            ftpClient.connect(HOST,PORT);
            fileInputStream = file.getInputStream();
            ftpClient.login(USER,PASSWORD);

            ftpClient.changeWorkingDirectory(basePath);
            String[] strings = dir.split("/");
            for (String s:strings)
            {
                ftpClient.makeDirectory(s);
                ftpClient.changeWorkingDirectory(s);
            }
            ftpClient.setFileType(fileType);
            flag = ftpClient.storeFile(fileName,fileInputStream);

        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }
}
