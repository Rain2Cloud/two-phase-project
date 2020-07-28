package com.aaa.yay.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

import java.io.*;
import java.net.SocketException;

/**
 * @Author yay
 * @Description Ftp上传工具类
 * @CreatTime 2020年 07月13日 星期一 21:07:33
 */
@Slf4j
public class FtpUtils {

    private FtpUtils(){

    }

    /**
    * 上传方法
     *      *      host:ftp服务器的ip地址
     *      *      port:ftp服务器的端口号
     *      *      username:ftp服务器的用户名
     *      *      password:ftp服务器的密码
     *      *      basePath:用户上传文件的根路径
     *      *      filePath:用户上传当天日期路径
     *      *      fileName:修改之后的文件名
     *      *      inputStream:使用IO上传
    * @author yay
    * @param host port username password basePath filePath filename inputStream
    * @updateTime 2020/07/13 21:36
    * @throws
    * @return java.lang.Boolean
    */
    public static Boolean upload(String host, Integer port, String username, String password, String basePath,
                                 String filePath, String filename, InputStream inputStream){
        /**
         * 按照每天的日期作为文件夹来进行上传
         */
        // 1.创建临时路径
        String tempPath = "";
        // 2.创建FTPClient对象(这个对象就是FTP给java所提供的API)
        FTPClient ftpClient = new FTPClient();
        // 3.定义返回状态码
        int replyCode;
        // 4.连接ftp
        try {
            ftpClient.connect(host,port);
            // 5.登录ftp服务器
            ftpClient.login(username,password);
            // 6.接收返回的状态码 如果成功返回230，如果失败返回503
            replyCode = ftpClient.getReplyCode();
            // 7.判断
            if (!FTPReply.isPositiveCompletion(replyCode)){
                // 连接失败了
                ftpClient.disconnect();
                return false;
            }
            // 8.先检测我要上传的目录是否存在(2020/07/13)
            // basePath:/home/ftp
            // filePath: /2020/07/10
            // --->/home/ftp/2020/07/13
            if (!ftpClient.changeWorkingDirectory(basePath + filePath)){
                // 该文件夹不存在
                // 9.创建文件夹
                // [2020, 07, 13] ["", "2020", "07", "13"]
                String[] dirs = filePath.split("/");
                // 10.把basePath赋值给临时路径
                // tempPath:/home/ftp
                tempPath = basePath;
                // 11.循环
                for (String dir : dirs){
                    // 严谨判断--->获取当前循环出来的String类型文件夹地址(2020)
                    if (null == dir || "".equals(dir)){
                        // 没有截取到数据，在这不能直接return，因为循环还没有结束，continue是跳过当前循环，进入下一次循环
                        continue;
                    }
                    // 12.说明有数据，拼接临时路径(如果没有进入if，则取到的值应该就是2020)
                    tempPath += "/" + dir;
                    // tempPath: /home/ftp/2020
                    // 13.再次检测tempPath是否存在
                    if (!ftpClient.changeWorkingDirectory(tempPath)){
                        // 文件夹不存在
                        // 14.创建文件夹
                        if (!ftpClient.makeDirectory(tempPath)){
                            // 说明文件夹创建失败
                            return false;
                        }else {
                            // 15.严谨判断，判断创建出来的目录确实存在
                            ftpClient.changeWorkingDirectory(tempPath);
                        }
                    }
                }
            }
            // 16.把文件转换为二进制的形式来进行上传
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            // 17.这里才是真正的文件上传
            if (!ftpClient.storeFile(filename,inputStream)){
                // 说明上传失败
                return false;
            }
            // 18.关闭输入流
            inputStream.close();
            // 19.退出ftp
            ftpClient.logout();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            // 20.判断当前ftp服务器是否处于正在连接状态
            if (ftpClient.isConnected()){
                try {
                    // 说明还在连接中(说明正在占用资源)
                    ftpClient.disconnect();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }

    /**
    * @Auther: czb
    * @Description:
     * 登录FTP服务器
     * @Date: 2020/7/24 19:56
    * @param [host, port, username, password]
    * @return org.apache.commons.net.ftp.FTPClient
    */

    public static FTPClient getFtpClient(String host, int port, String username, String password){
        //创建FTPClient对象,这是ftp给java提供的api
        FTPClient ftpClient = new FTPClient();
        try {
            // 连接FTP服务器，如果采用默认端口，可以使用ftp.connect(host)的方式直接连接FTP服务器
            ftpClient.connect(host,port);
            // 登录FTP服务器
            ftpClient.login(username,password);
            // 如果登录成功，返回码是230。如果失败，则返回530/503
            int replyCode = ftpClient.getReplyCode();
            // 判断返回码是否合法，如果不合法说明账号和密码错误
            if (!FTPReply.isPositiveCompletion(replyCode)){
                log.info("未连接到FTP，用户名或密码错误。");
                //如果连接失败，释放资源
                ftpClient.disconnect();
                return null;
            }else {
                log.info("FTP连接成功。");
                return ftpClient;
            }
        } catch (SocketException e) {
            e.printStackTrace();
            log.info("FTP的IP地址可能错误，请正确配置。");
        } catch (IOException e) {
            e.printStackTrace();
            log.info("FTP的端口错误,请正确配置。");
        }
        return ftpClient;
    }



    /**
    * @Auther: czb
    * @Description:
     * 下载文件
    * @Date: 2020/7/24 19:57
    * @param [host, port, username, password, ftpPath, localPath, fileName]
    * @return java.io.File
    */
    public static File downloadFtpFile(String host, int port, String username, String password, String ftpPath,
                                       String localPath, String fileName){
        FTPClient ftpClient = null;
        try {
            //获取连接
            ftpClient = getFtpClient(host, port, username, password);
            //设置中文支持
            ftpClient.setControlEncoding("UTF-8");
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftpClient.enterLocalPassiveMode();
            ftpClient.changeWorkingDirectory(ftpPath);
            //判断目录下是否存在文件，如果不存在则创建文件
            File localFile  = new File(localPath, fileName);
            if (!localFile.getParentFile().exists()){
                localFile.getParentFile().mkdirs();
            }
            //创建文件
            OutputStream outputStream = new FileOutputStream(localFile);
            //下载文件
            ftpClient.retrieveFile(fileName, outputStream);
            outputStream.close();
            ftpClient.logout();
            return localFile;
        } catch (FileNotFoundException e) {
            log.error("没有找到" + ftpPath + "文件，" + e);
        } catch (SocketException e) {
            log.error("连接FTP失败， " + e);
        } catch (IOException e) {
            log.error("文件读取错误。" + e);
        } finally {
            if (ftpClient != null && ftpClient.isConnected()){
                try {
                    ftpClient.disconnect();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /**
    * @Auther: czb
    * @Description:
     * 检验指定路径的文件是否存在ftp服务器中
     * filePath--指定绝对路径的文件
    * @Date: 2020/7/24 19:57
    * @param [hostname, port, username, password, filePath]
    * @return boolean
    */

    public static boolean isFTPFileExist(final String hostname, final int port, final String username,
                                         final String password, final String filePath) {
        log.info("判断文件在ftp上是否存在！");
        boolean exists = false;
        final FTPClient ftpClient = getFtpClient(hostname, port, username, password);
        try {
            final FTPFile[] files = ftpClient.listFiles(new String(filePath.getBytes("UTF-8"), "ISO-8859-1"));
            if (files != null && files.length > 0) {
                exists = true;
            }
        } catch (final IOException e) {
            log.error("failed to judge whether the file (" + filePath + ") is existed");
        }
        log.info("文件" + filePath + "在ftp上是否存在?" + exists);
        return exists;
    }


    /**
    * @Auther: czb
    * @Description:
     * 删除ftp的文件
    * @Date: 2020/7/24 19:57
    * @param [hostname, port, username, password, ftpPath]
    * @return boolean
    */

    public static boolean deleteFile (final String hostname, final int port, final String username,
                                      final String password, final String ftpPath) {
        if (ftpPath != null && ftpPath != "") {
            final FTPClient ftpClient = getFtpClient(hostname, port, username, password);
            if (ftpPath.endsWith("/")) {
                log.info("错误的文件路径");
                return false;
            }
            try {
                final boolean exists = isFTPFileExist(hostname, port, username, password, ftpPath);
                if (exists) {
                    ftpClient.deleteFile(new String(ftpPath.getBytes("GBK"), "iso-8859-1"));
                } else {
                    log.info("文件" + ftpPath + "已经不存在");
                    return true;
                }
            } catch (IOException e) {
                log.error("FTP上文件删除失败！", e);
                return false;
            }
        } else {
            log.info("没有需要删除的文件！");
        }
        return true;
    }





}
