package cn.njcit.DTO;

/**
 * @作者：胡鹏鹏
 * @创建时间：2018/3/7 9:53
 * 上传文件,图片等属性信息类
 */
public class RequestConfig {
    private String action;
    private String encode;
    private String id;
    private String name;
    private String type;
    private String lastModifiedDate;
    private String size;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getEncode() {
        return encode;
    }

    public void setEncode(String encode) {
        this.encode = encode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(String lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "RequestConfig{" +
                "action='" + action + '\'' +
                ", encode='" + encode + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", lastModifiedDate='" + lastModifiedDate + '\'' +
                ", size='" + size + '\'' +
                '}';
    }
}
