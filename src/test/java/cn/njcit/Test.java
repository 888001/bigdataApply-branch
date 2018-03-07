package cn.njcit;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minidev.json.writer.BeansMapper.Bean;

import com.alibaba.druid.support.json.JSONParser;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.JsonParserDelegate;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Test {
    private static final String[] fields = {
        "main_student_no", "main_student_name", "main_student_specialty", "main_student_phone", "main_student_email", "main_student_QQ", "main_student_department", "main_student_grade",
        "student1_no", "student1_name", "student1_department", "student1_specialty", "student1_grade", "student1_phone", "student1_email", "student1_QQ",
        "student2_no", "student2_name", "student2_department", "student2_specialty", "student2_grade", "student2_phone", "student2_email", "student2_QQ",
        "teacher_name", "teacher_department", "teacher_phone", "teacher_email", "teacher_QQ", "works_no", "works_name"
};

    public synchronized static int getFirt(String s,String key) {
        return s.lastIndexOf(key);
    }

    public synchronized static int getLast(String s) {
        return s.indexOf(",");
    }
    public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
    	//ObjectMapper mapper = new ObjectMapper();  
    	String a="\"appid\"=7f16042c-bbdd-4aa7-98f6-f29f37599c6d&\"data\"={\"main_student_no\":\"15511122213\",\"main_student_name\":\"问我\",\"main_student_specialty\":\"15511122213\",\"main_student_phone\":\"15511122213\",\"main_student_email\":\"15511122213@qq.com\",\"main_student_QQ\":\"15511122213\",\"main_student_department\":\"电子信息学院\",\"main_student_grade\":\"16级\",\"student1_no\":\"15511122213\",\"student1_name\":\"问我\",\"student1_department\":\"15511122213\",\"student1_specialty\":\"15511122213\",\"student1_grade\":\"15511122213\",\"student1_phone\":\"15511122213\",\"student1_email\":\"15511122213@qq.cn\",\"student1_QQ\":\"15511122213\",\"student2_no\":\"15511122213\",\"student2_name\":\"恩恩\",\"student2_department\":\"15511122213\",\"student2_specialty\":\"15511122213\",\"student2_grade\":\"15511122213\",\"student2_phone\":\"15511122213\",\"student2_email\":\"15511122213@qq.com\",\"student2_QQ\":\"15511122213\",\"teacher_name\":\"搜索\",\"teacher_department\":\"搜索\",\"teacher_phone\":\"15511122213\",\"teacher_email\":\"15511122213@qq.com\",\"teacher_QQ\":\"15511122213\",\"works_no\":\"2.桌面应用软件设计--基于windows桌面PDF格式转换软件\",\"works_name\":\"搜索\"}&\"isAjax\"=true";
    	Map<String, String> vmap = new HashMap<String, String>();
    	for(String field:fields ){
    		vmap.put(field, getValue(a, field));
    	}

    	
    	
    	
    	
    	
    	int nq = 0;
    	/*JavaType javaType = mapper.getTypeFactory().constructParametricType(List.class, Bean.class);
    	//如果是Map类型  mapper.getTypeFactory().constructParametricType(HashMap.class,String.class, Bean.class);
    	List<Bean> lst =  (List<Bean>)mapper.readValue(a, javaType); */
/*    	List<Bean> beanList = mapper.readValue(a, new TypeReference<List<Bean>>() {}); 
		String aa = "";*/
    	//Collection<Object> readValues = new ObjectMapper().readValue(a, new TypeReference<Collection<Object>>() { });
		
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
    	//如果得不到,也就是前端没传,直接put"";
    	if(-1==first){
    		return "";
    	}
    	//截取到当前key值为首字位置
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
}
