package cn.njcit.constans;


import net.sf.json.JSONObject;

import java.util.Map;

/**
 * @作者：胡鹏鹏
 * @创建时间：2018/3/7 10:14
 */
public class Constans {
    //上传的图片保存路径
    public final static String IMG_STORAGE_PATH = "E:/";
    //上传的文件回显前端的url地址,打包到不同服务器需要变化;
    //默认都是一样,后续如果分fastdfs将不同文件分别存储可能地址会变
    public final static String IMG_WEB_URL = "http://localhost:8080/";
    public final static String FILE_WEB_URL = "http://localhost:8080/";
    public final static String VIDEO_WEB_URL = "http://localhost:8080/";
    public final static String SCRAWL_WEB_URL = "http://localhost:8080/";
    public final static String CONFIG = "{\n" +
            "    \"imageActionName\": \"uploadimage\",\n" +
            "    \"imageFieldName\": \"upfile\",\n" +
            "    \"imageMaxSize\": 2048000,\n" +
            "    \"imageAllowFiles\": [\n" +
            "        \".png\",\n" +
            "        \".jpg\",\n" +
            "        \".jpeg\",\n" +
            "        \".gif\",\n" +
            "        \".bmp\"\n" +
            "    ],\n" +
            "    \"imageCompressEnable\": true,\n" +
            "    \"imageCompressBorder\": 1600,\n" +
            "    \"imageInsertAlign\": \"none\",\n" +
            "    \"imageUrlPrefix\": \"http://localhost:8080/\",\n" +
            "    \"imagePathFormat\": \"/ueditor/jsp/upload/image/{yyyy}{mm}{dd}/{time}{rand:6}\",\n" +
            "    \"scrawlActionName\": \"uploadscrawl\",\n" +
            "    \"scrawlFieldName\": \"upfile\",\n" +
            "    \"scrawlPathFormat\": \"/ueditor/jsp/upload/image/{yyyy}{mm}{dd}/{time}{rand:6}\",\n" +
            "    \"scrawlMaxSize\": 2048000,\n" +
            "    \"scrawlUrlPrefix\": \"\",\n" +
            "    \"scrawlInsertAlign\": \"none\",\n" +
            "    \"snapscreenActionName\": \"uploadimage\",\n" +
            "    \"snapscreenPathFormat\": \"/ueditor/jsp/upload/image/{yyyy}{mm}{dd}/{time}{rand:6}\",\n" +
            "    \"snapscreenUrlPrefix\": \"\",\n" +
            "    \"snapscreenInsertAlign\": \"none\",\n" +
            "    \"catcherLocalDomain\": [\n" +
            "        \"127.0.0.1\",\n" +
            "        \"localhost\",\n" +
            "        \"img.baidu.com\"\n" +
            "    ],\n" +
            "    \"catcherActionName\": \"catchimage\",\n" +
            "    \"catcherFieldName\": \"source\",\n" +
            "    \"catcherPathFormat\": \"/ueditor/jsp/upload/image/{yyyy}{mm}{dd}/{time}{rand:6}\",\n" +
            "    \"catcherUrlPrefix\": \"\",\n" +
            "    \"catcherMaxSize\": 2048000,\n" +
            "    \"catcherAllowFiles\": [\n" +
            "        \".png\",\n" +
            "        \".jpg\",\n" +
            "        \".jpeg\",\n" +
            "        \".gif\",\n" +
            "        \".bmp\"\n" +
            "    ],\n" +
            "    \"videoActionName\": \"uploadvideo\",\n" +
            "    \"videoFieldName\": \"upfile\",\n" +
            "    \"videoPathFormat\": \"/ueditor/jsp/upload/video/{yyyy}{mm}{dd}/{time}{rand:6}\",\n" +
            "    \"videoUrlPrefix\": \"\",\n" +
            "    \"videoMaxSize\": 102400000,\n" +
            "    \"videoAllowFiles\": [\n" +
            "        \".flv\",\n" +
            "        \".swf\",\n" +
            "        \".mkv\",\n" +
            "        \".avi\",\n" +
            "        \".rm\",\n" +
            "        \".rmvb\",\n" +
            "        \".mpeg\",\n" +
            "        \".mpg\",\n" +
            "        \".ogg\",\n" +
            "        \".ogv\",\n" +
            "        \".mov\",\n" +
            "        \".wmv\",\n" +
            "        \".mp4\",\n" +
            "        \".webm\",\n" +
            "        \".mp3\",\n" +
            "        \".wav\",\n" +
            "        \".mid\"\n" +
            "    ],\n" +
            "    \"fileActionName\": \"uploadfile\",\n" +
            "    \"fileFieldName\": \"upfile\",\n" +
            "    \"filePathFormat\": \"/ueditor/jsp/upload/file/{yyyy}{mm}{dd}/{time}{rand:6}\",\n" +
            "    \"fileUrlPrefix\": \"\",\n" +
            "    \"fileMaxSize\": 51200000,\n" +
            "    \"fileAllowFiles\": [\n" +
            "        \".png\",\n" +
            "        \".jpg\",\n" +
            "        \".jpeg\",\n" +
            "        \".gif\",\n" +
            "        \".bmp\",\n" +
            "        \".flv\",\n" +
            "        \".swf\",\n" +
            "        \".mkv\",\n" +
            "        \".avi\",\n" +
            "        \".rm\",\n" +
            "        \".rmvb\",\n" +
            "        \".mpeg\",\n" +
            "        \".mpg\",\n" +
            "        \".ogg\",\n" +
            "        \".ogv\",\n" +
            "        \".mov\",\n" +
            "        \".wmv\",\n" +
            "        \".mp4\",\n" +
            "        \".webm\",\n" +
            "        \".mp3\",\n" +
            "        \".wav\",\n" +
            "        \".mid\",\n" +
            "        \".rar\",\n" +
            "        \".zip\",\n" +
            "        \".tar\",\n" +
            "        \".gz\",\n" +
            "        \".7z\",\n" +
            "        \".bz2\",\n" +
            "        \".cab\",\n" +
            "        \".iso\",\n" +
            "        \".doc\",\n" +
            "        \".docx\",\n" +
            "        \".xls\",\n" +
            "        \".xlsx\",\n" +
            "        \".ppt\",\n" +
            "        \".pptx\",\n" +
            "        \".pdf\",\n" +
            "        \".txt\",\n" +
            "        \".md\",\n" +
            "        \".xml\"\n" +
            "    ],\n" +
            "    \"imageManagerActionName\": \"listimage\",\n" +
            "    \"imageManagerListPath\": \"/ueditor/jsp/upload/image/\",\n" +
            "    \"imageManagerListSize\": 20,\n" +
            "    \"imageManagerUrlPrefix\": \"\",\n" +
            "    \"imageManagerInsertAlign\": \"none\",\n" +
            "    \"imageManagerAllowFiles\": [\n" +
            "        \".png\",\n" +
            "        \".jpg\",\n" +
            "        \".jpeg\",\n" +
            "        \".gif\",\n" +
            "        \".bmp\"\n" +
            "    ],\n" +
            "    \"fileManagerActionName\": \"listfile\",\n" +
            "    \"fileManagerListPath\": \"/ueditor/jsp/upload/file/\",\n" +
            "    \"fileManagerUrlPrefix\": \"\",\n" +
            "    \"fileManagerListSize\": 20,\n" +
            "    \"fileManagerAllowFiles\": [\n" +
            "        \".png\",\n" +
            "        \".jpg\",\n" +
            "        \".jpeg\",\n" +
            "        \".gif\",\n" +
            "        \".bmp\",\n" +
            "        \".flv\",\n" +
            "        \".swf\",\n" +
            "        \".mkv\",\n" +
            "        \".avi\",\n" +
            "        \".rm\",\n" +
            "        \".rmvb\",\n" +
            "        \".mpeg\",\n" +
            "        \".mpg\",\n" +
            "        \".ogg\",\n" +
            "        \".ogv\",\n" +
            "        \".mov\",\n" +
            "        \".wmv\",\n" +
            "        \".mp4\",\n" +
            "        \".webm\",\n" +
            "        \".mp3\",\n" +
            "        \".wav\",\n" +
            "        \".mid\",\n" +
            "        \".rar\",\n" +
            "        \".zip\",\n" +
            "        \".tar\",\n" +
            "        \".gz\",\n" +
            "        \".7z\",\n" +
            "        \".bz2\",\n" +
            "        \".cab\",\n" +
            "        \".iso\",\n" +
            "        \".doc\",\n" +
            "        \".docx\",\n" +
            "        \".xls\",\n" +
            "        \".xlsx\",\n" +
            "        \".ppt\",\n" +
            "        \".pptx\",\n" +
            "        \".pdf\",\n" +
            "        \".txt\",\n" +
            "        \".md\",\n" +
            "        \".xml\"\n" +
            "    ]\n" +
            "}";

    public static Map getConfig() {
        JSONObject json = JSONObject.fromObject(Constans.CONFIG);
        Map map = json;
        map.put("imageUrlPrefix", Constans.IMG_WEB_URL);
        map.put("fileUrlPrefix", Constans.FILE_WEB_URL);
        map.put("videoUrlPrefix", Constans.VIDEO_WEB_URL);
        map.put("scrawlUrlPrefix", Constans.SCRAWL_WEB_URL);
        return map;
    }

    public static void main(String[] a1) {

        Map map = (Map) Constans.getConfig();
        String a = (String) map.get("imageUrlPrefix");
    }
}
