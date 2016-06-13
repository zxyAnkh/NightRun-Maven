package cn.edu.zucc.handle;

/**
 * Created by zxy on 6/13/2016.
 */
public class ErrorCode {
    private static final String ERROR_01 = "操作失败";
    private static final String ERROR_02 = "数据异常";

    public static String getError(int id){
        switch (id){
            case 1:
                return ERROR_01;
            case 2:
                return ERROR_02;
            default:
                break;
        }
        return "";
    }

}
