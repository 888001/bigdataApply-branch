package cn.njcit.controller;

import cn.njcit.DTO.RequestConfig;
import cn.njcit.DTO.TestDTO;
import cn.njcit.constans.Constans;
import cn.njcit.utils.PathUtils;
import cn.njcit.utils.UploadUtils;
import com.baidu.ueditor.PathFormat;
import com.baidu.ueditor.define.AppInfo;
import com.baidu.ueditor.define.BaseState;
import com.baidu.ueditor.define.FileType;
import com.baidu.ueditor.define.State;
import com.baidu.ueditor.upload.StorageManager;
import net.sf.json.JSONArray;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @作者：胡鹏鹏
 * @创建时间：2018/3/6 22:14
 * Ueditor的配置类
 */
@RestController
public class UEditorController {
    @RequestMapping(value = "/ueditor")
    public String config(HttpServletRequest request, HttpServletResponse response, RequestConfig conf) throws Exception {
        String action = conf.getAction();
        if ("uploadimage".equals(action)) {
           return uploadfile(request);
        } else if ("config".equals(conf.getAction())) {
            response.setContentType("application/json");
            String rootPath = request.getSession().getServletContext().getRealPath("/");
            try {
                String config = Constans.CONFIG;
                PrintWriter writer = response.getWriter();
                //writer.write(config);
                writer.write(Constans.getConfig().toString());
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if("uploadfile".equals(conf.getAction())){
            //上传文件逻辑代码
            return uploadfile(request);
        }else if("uploadvideo".equals(conf.getAction())){
            return uploadfile(request);
        }else if("uploadscrawl".equals(conf.getAction())){
            //上传涂鸦不知道为什么不行,干脆不要这个功能
            return uploadfile(request);
        }

        return null;
    }
    @RequestMapping("/uploadimage")
    public String uploadimage(HttpServletRequest request, RequestConfig conf) throws Exception {
        return uploadfile(request);
    }

    private static boolean validType(String type, JSONArray array) {
        boolean hasType=false;
        List list = new ArrayList();

        for(int i=0;i<array.size();i++) {
            String value= (String) array.get(i);
            list.add(value);
        }
        return list.contains(type);
    }
    @RequestMapping("/get")
    public String get(){
        BaseState storageState = new BaseState(true);
        storageState.putInfo("state","SUCCESS");
        storageState.putInfo("url", "upload/"+"111.jpg");
        storageState.putInfo("title", "111.jpg");
        storageState.putInfo("original", "111.jpg");
        return storageState.toJSONString();
    }
    @RequestMapping("/gett")
    public String gett(){
        TestDTO t  = new TestDTO() ;
        t.aaaa = "aaaaa";
        t.mmm = "aaaaassfdd";
        t.infoMap.put("asa","asadda");
        return t.toString();
    }
    public String uploadfile(HttpServletRequest request) throws Exception {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile file = multipartRequest.getFile("upfile");
        String savePath = PathUtils.getJarStaticPath()+ "/"+file.getOriginalFilename()  ;
        String originFileName = file.getOriginalFilename();
        String suffix = FileType.getSuffixByFilename(originFileName);
        InputStream is = file.getInputStream();
        UploadUtils.upload(is,file.getOriginalFilename());
        BaseState storageState = new BaseState();
        //ueditor 返回参数如api所示http://fex.baidu.com/ueditor/#dev-request_specification
        //注mimetype为application/json
        storageState.putInfo("state","SUCCESS");
        storageState.putInfo("url", "upload/"+file.getOriginalFilename());
        storageState.putInfo("title", file.getOriginalFilename());
        storageState.putInfo("original", file.getOriginalFilename());
        return storageState.toJSONString();
    }
}
