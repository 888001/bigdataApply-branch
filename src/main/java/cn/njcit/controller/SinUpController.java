package cn.njcit.controller;



import cn.njcit.dao.ReportMapper;
import cn.njcit.mapper.model.Report;
import cn.njcit.utils.ReflectFields;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.net.URLDecoder;
import java.util.*;

/**
 * @作者：胡鹏鹏
 * @创建时间：2018/1/20 17:53
 */
@RestController
@RequestMapping("/form")
public class SinUpController {

    private static final String[] fields = {
            "main_student_no", "main_student_name", "main_student_specialty", "main_student_phone", "main_student_email", "main_student_QQ", "main_student_department", "main_student_grade",
            "student1_no", "student1_name", "student1_department", "student1_specialty", "student1_grade", "student1_phone", "student1_email", "student1_QQ",
            "student2_no", "student2_name", "student2_department", "student2_specialty", "student2_grade", "student2_phone", "student2_email", "student2_QQ",
            "teacher_name", "teacher_department", "teacher_phone", "teacher_email", "teacher_QQ", "works_no", "works_name"
    };
    @Autowired
    ReportMapper reportMapper;

    /*    {\"1516347929360\":\"学生负责人学号\",\"1516347929361\":\"学生负责人姓名\",\"1516349264621\":\"学生负责人专业\",
    \"1516349273675\":\"学生负责人手机\",\"1516349337388\":\"学生负责人邮箱\",\"1516349342444\":\"学生负责人QQ\",\
            "1516350388788\":\"学生负责人所属分院\",\"1516350673843\":\"学生负责人年级\",\"1516351102484\":\"学生组员1学号\
            ",\"1516351118406\":\"学生组员1姓名\",\"1516351123143\":\"学生组员1所属分院\",\"1516351126645\":\"学生组员1专业\"
    ,\"1516351131174\":\"学生组员1年级\",\"1516351136219\":\"学生组员1手机号\",\"1516351140628\":\"学生组员1邮箱\",\
            "1516351147597\":\"学生组员1QQ号\",\"1516351371398\":\"学生组员2学号\",\"1516351371400\":\"学生组员2姓名\",
    \"1516351371401\":\"学生组员2所属分院\",\"1516351371402\":\"学生组员2专业\",\"1516351371403\":\"学生组员2年级\
            ",\"1516351371404\":\"学生组员2手机号\",\"1516351371405\":\"学生组员2邮箱\",\"1516351371406\":\"学生组员2QQ号\
            ",\"1516351439671\":\"指导老师姓名\",\"1516351439673\":\"指导老师所属分院\",\"1516351439674\":\"指导老师手机号\
            ",\"1516351439676\":\"指导老师邮箱\",\"1516351439678\":\"指导老师qq号\",\"1516351952598\":\"作品题目在赛项规程中的编号\
            ",\"1516352107187\":\"作品名称\"}*/
    @RequestMapping("/freedata")
    public String formData(@RequestBody String map) throws Exception {
        map = URLDecoder.decode(map, "utf-8");
        map = cleanString(map);
        Map<String, String> vmap = new HashMap<String, String>();
        for(String field:fields ){
            vmap.put(field, getValue(map, field));
        }
        Report  report = new Report();
        ReflectFields reflectFields = new ReflectFields(report, vmap);
        report=reflectFields.getFields();
        report.setCreateTime(new Date());
        //reportRepository.saveAndFlush(report);
        reportMapper.insert(report);
        return "ok";
    }

    public Map<String, String> getProperties(String real) {

        Map<String, String> map = new HashMap<String, String>();
        return map;
    }
    public synchronized static int getFirt(String s,String key) {
        return s.lastIndexOf(key);
    }

    public synchronized static int getLast(String s) {
        return s.indexOf(",");
    }
    /**
     * @Title: getValue
     * @Description: 得到value
     * @param @param s
     * @param @param key
     * @param @return
     * @return String
     * @throws
     */
    public synchronized static String getValue(String s,String key){
        int first=getFirt(s, key);
        //截取到当前key值为首字位置
        if(-1==first){
            return "";
        }
        String aa = s.substring(first);
        //找到value所在的,
        int n = getLast(aa);
        //找第一个:号
        int mm = aa.indexOf(":");
        //找第一个,号
        //如果是works_name,最后一个没有,只有}
        if("works_name".equals(key)){
            int dd = aa.indexOf("}");
            //得到value
            String value  = aa.substring(mm+2,dd-1);
            return value;
        }else {
            int dd = aa.indexOf(",");
            //得到value
            String value  = aa.substring(mm+2,dd-1);
            return value;
        }
    }
    public String cleanString(String a){
        a=a.replaceAll("appid","\"appid\"");
        a=a.replaceAll("data","\"data\"");
        a=a.replaceAll("isAjax","\"isAjax\"");

        a=a.replaceAll("1516347929360", "main_student_no");
        a=a.replaceAll("1516347929361", "main_student_name");
        a=a.replaceAll("1516349264621", "main_student_specialty");
        a=a.replaceAll("1516349273675", "main_student_phone");
        a=a.replaceAll("1516349337388", "main_student_email");
        a=a.replaceAll("1516349342444", "main_student_QQ");
        a=a.replaceAll("1516350388788", "main_student_department");
        a=a.replaceAll("1516350673843", "main_student_grade");
        a=a.replaceAll("1516351102484", "student1_no");
        a=a.replaceAll("1516351118406", "student1_name");
        a=a.replaceAll("1516351123143", "student1_department");
        a=a.replaceAll("1516351126645", "student1_specialty");
        a=a.replaceAll("1516351131174", "student1_grade");
        a=a.replaceAll("1516351136219", "student1_phone");
        a=a.replaceAll("1516351140628", "student1_email");
        a=a.replaceAll("1516351147597", "student1_QQ");
        a=a.replaceAll("1516351371398", "student2_no");
        a=a.replaceAll("1516351371400", "student2_name");
        a=a.replaceAll("1516351371401", "student2_department");
        a=a.replaceAll("1516351371402", "student2_specialty");
        a=a.replaceAll("1516351371403", "student2_grade");
        a=a.replaceAll("1516351371404", "student2_phone");
        a=a.replaceAll("1516351371405", "student2_email");
        a=a.replaceAll("1516351371406", "student2_QQ");
        a=a.replaceAll("1516351439671", "teacher_name");
        a=a.replaceAll("1516351439673", "teacher_department");
        a=a.replaceAll("1516351439674", "teacher_phone");
        a=a.replaceAll("1516351439676", "teacher_email");
        a=a.replaceAll("1516351439678", "teacher_QQ");
        a=a.replaceAll("1516351952598", "works_no");
        a=a.replaceAll("1516352107187", "works_name");
        return a;
    }

}
