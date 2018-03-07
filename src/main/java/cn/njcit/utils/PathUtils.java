package cn.njcit.utils;

import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * @作者：胡鹏鹏
 * @创建时间：2018/3/7 14:06
 */
public class PathUtils {
    public static String getRootPath() throws FileNotFoundException {
        File path = new File(ResourceUtils.getURL("classpath:").getPath());
        if(!path.exists()){ path = new File("");}
        return path.getAbsolutePath();
    }
    public static String getJarStaticPath() throws FileNotFoundException {
        File path = new File(ResourceUtils.getURL("classpath:").getPath());
        if(!path.exists()){ path = new File("");}
        File upload = new File(path.getAbsolutePath(),"static/upload/");
        if(!upload.exists()){
            upload.mkdirs();
        }
        return upload.getAbsolutePath();
    }
    public static void main(String[] a) throws FileNotFoundException {
        PathUtils.getJarStaticPath();
    }
}
