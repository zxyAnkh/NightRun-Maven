package cn.edu.zucc.web.common;

/**
 * Created by zxy on 11/13/2016.
 */
public class Branch {
    private static final String JS = "计算";

    private static final String YX = "医学";

    private static final String FX = "法学";

    public static String getBranch(int branch) {
        switch (branch) {
            case 1:
                return JS;
            case 4:
                return YX;
            case 9:
                return FX;
            default:
                return null;
        }
    }
}
