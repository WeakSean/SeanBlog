package cn.sean.blogback.common;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 通用返回结果，服务端响应的数据最终都会封装成此对象
 */
@Data
public class R extends HashMap<String,Object> {

    public R(){
        this.put(("code"),0);
    }

    public static R error(){
        return error(500,"未知错误请联系管理员");
    }


    public static R error(int code,String msg){
        R r = new R();
        r.put((String)"code",code);
        r.put((String)"msg",msg);
        return r;
    }

    public static R success(String msg){
        R r = new R();
        r.put((String)"msg" ,msg);
        return r;
    }

    public static R success(Map<String,Object> map){
        R r = new R();
        r.putAll(map);
        return r;
    }

    public static R list(Integer count, List<?> data){
        R r = new R();
        Map<String,Object> res = new HashMap();
        res.put("count",count);
        res.put("list",data);
        return r.put((String)"data",res);
    }

    public static R success(){
        return new R();
    }

    public R put(String key, Object value){
        super.put(key,value);
        return this;
    }




//
//    public static <T> R<T> success(T object) {
//        R<T> r = new R<T>();
//        r.data = object;
//        r.msg = "成功了喵";
//        r.code = 1;
//        return r;
//    }
//
//    public static
//
//    public static <T> R<T> error(String msg) {
//        R r = new R();
//        r.msg = msg;
//        r.code = 0;
//        return r;
//    }
//
//    public R<T> add(String key, Object value) {
//        this.map.put(key, value);
//        return this;
//    }

}
