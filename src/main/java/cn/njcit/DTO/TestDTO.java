package cn.njcit.DTO;

import java.util.HashMap;
import java.util.Map;

/**
 * @作者：胡鹏鹏
 * @创建时间：2018/3/7 16:27
 */
public class TestDTO {
    public String mmm;
    public String aaaa;
    public Map<String, String> infoMap = new HashMap();

    @Override
    public String toString() {
        return "TestDTO{" +
                "mmm='" + mmm + '\'' +
                ", aaaa='" + aaaa + '\'' +
                ", infoMap=" + infoMap +
                '}';
    }
}
