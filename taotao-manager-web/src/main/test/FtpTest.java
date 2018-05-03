import org.apache.commons.net.ftp.FTPClient;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import  java.io.File;
import java.io.IOException;

/**
 * @Description
 * @Author: liuXuyang
 * @studentNo 15130110024
 * @Emailaddress 1187697635@qq.com
 * @Date: 2018/5/2 20:57
 */
public class FtpTest {


    @Test
    public void testFtp() throws Exception {
        //连接ftp服务器
        FTPClient ftpClient = new FTPClient();

        ftpClient.connect("119.23.75.180",21);

        //登录ftp服务器
        ftpClient.login("ftptest","ftptest");

        //读取本地文件
        FileInputStream inputStream = new FileInputStream(new File("/Users/mac/Downloads/timg.jpeg"));

        //上传文件
        //指定上传目录
        ftpClient.changeWorkingDirectory("/home/ftpuser/www/images");
        String[] strings = new String[]{"1","2","3"};
        for (String s:strings)
        {
            ftpClient.makeDirectory(s);
            ftpClient.changeWorkingDirectory(s);
        }

        //指定文件类型
        ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
        /**
         * 第一个参数：文件在远程服务器的名称
         * 第二个参数：文件流
         */
        boolean flag  =ftpClient.storeFile("test.jpg",inputStream);
        inputStream.close();
        System.out.println(flag);
        //退出登录
//        ftpClient.logout();
    }
}
