package cn.njcit.utils;

import java.io.*;

/**
 * @作者：胡鹏鹏
 * @创建时间：2018/3/7 14:16
 */
public class UploadUtils {
    public static boolean upload(InputStream is,String name)  {
        try {
            File file = new File(PathUtils.getJarStaticPath()+"/"+name);
            OutputStream os=new FileOutputStream(file);
            byte buffer[]=new byte[1024];
            int cnt=0;
            while((cnt=is.read(buffer))>0){
                os.write(buffer, 0, cnt);
            }
            os.close();
            is.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
