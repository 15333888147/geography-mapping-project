package gpm.utils;

import com.aaa.gpm.utils.StringUtils;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: gcy
 * @DateTime: 2020/7/10 15:07
 * @Description: TODO ftp工具类
 */
public class FtpUtils {
    private FtpUtils() {
    }
    /**@DateTime: 2020/7/10 15:10
    * @Params: [host, port, username, password, basePath, filePath, fileName, inputStream]
    * @Return java.lang.Boolean
    * 描述：
     *      按照每天日期的文件夹来进行上传
    */
    public static Boolean upload(String host, Integer port, String username, String password, String basePath, String filePath, String fileName, InputStream inputStream){
        /**
         * 1.创建临时路径
         */
        String tempPath = "";
        /**
         * 2.创建FTPClient对象(这个对象就是FTP给java所提供的API)
         */
        FTPClient ftpClient = new FTPClient();
        try {
            /**
             * 3.定义返回状态码
             */
            int replyCode;
            /**
             * 4.连接ftp
             */
            ftpClient.connect(host,port);
            /**
             * 5.登录ftp服务器
             */
            ftpClient.login(username,password);
            /**
             * 6.接收返回的状态码
             */
            replyCode = ftpClient.getReplyCode();
            /**
             * 7.判断
             */
            if (!FTPReply.isPositiveCompletion(replyCode)){
                /**
                 * 链接失败
                 */
                ftpClient.disconnect();
                return false;
            }
            /**
             * 8.先检测我要上传的目录是否存在(2020/07/10)
             */
            if (!ftpClient.changeWorkingDirectory(basePath + filePath)){
                //目录不存在
                /**
                 * 9.创建文件夹
                 */
                String[] dirs = filePath.split("/");
                /**
                 * 10.把basePath赋值给临时路径
                 */
                tempPath = basePath;
                /**
                 * 11.循环新创建的文件夹
                 */
                for (String dir : dirs) {
                    if (dir == null || StringUtils.isEmpty(dir)){
                        //说明dir为空，继续循环
                        continue;
                    }
                    /**
                     * 12.拼接临时路径
                     */
                    tempPath += "/" + dir;
                    /**
                     * 13.再次检测tempPath是否存在
                     */
                    if (!ftpClient.changeWorkingDirectory(tempPath)){
                        /**
                         * 14.创建文件夹
                         */
                        if (!ftpClient.makeDirectory(tempPath)){
                            //文件夹创建失败
                            return false;
                        }else {
                            /**
                             * 15.严谨判断，判断创建出来的目录确实存在
                             */
                            ftpClient.changeWorkingDirectory(tempPath);
                        }
                    }
                }
            }
            /**
             * 16.把文件转换为二进制的形式来进行上传
             */
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            /**
             * 17.这里才是真正的文件上传
             */
            if (!ftpClient.storeFile(fileName,inputStream)){
                //说明上传失败
                return false;
            }
            /**
             * 18.关闭输入流
             */
            inputStream.close();
            /**
             * 19.退出ftp
             */
            ftpClient.logout();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (ftpClient.isConnected()){
                try {
                    // 说明还在连接中(说明正在占用资源)
                    ftpClient.disconnect();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }
}
