package com.jiang.domain;

import java.util.HashMap;
import java.util.Map;
/**
 * @author 22498 jiangBoss
 * @create 2021-06-16
 * @time 9:02
 */
public class Msg {
    private int code;//状态码
    private String msg;//提示信息
    private Map<String,Object> extend=new HashMap<String,Object>();
    public static  Msg success(){
        Msg result=new Msg();
        result.setCode(100);
        result.setMsg("处理成功！");
        return  result;
    }
    public static Msg faild(){
        Msg msg=new Msg();
        msg.setCode(200);
        msg.setMsg("处理失败！");
        return  msg;
    }
    //链式操作
    public Msg add(String key,Object value){
        this.getExtend().put(key,value);
        return this;
    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }
}
