package cn.edu.zucc.handle;

/**
 * Created by zxy on 6/5/2016.
 */
public class Util {
    public static String getPostfix(String path){
        if(path == null || "".equals(path.trim()))
            return "";
        if(path.contains("."))
            return path.substring(path.lastIndexOf(".") + 1);
        return "";
    }
}

