package id.co.technicaltest.datakendaraan.models;

public class ResponseModel {
    private String msg;
    private Object data;
    
    public String getMsg() {
        return msg;
    }
    public Object getData() {
        return data;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public void setData(Object data) {
        this.data = data;
    }
}
