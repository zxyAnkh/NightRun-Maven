package cn.edu.zucc.handle;

/**
 * Created by zxy on 5/26/2016.
 */
public class Branch {
    private int branch;
    private String as;
    private String run;
    private String total;

    public String getAs() {
        return as;
    }

    public String getRun() {
        return run;
    }

    public String getTotal() {
        return total;
    }

    public void setBranch(int branch) {
        this.branch = branch;
        switch (branch) {
            case 1:
                this.as = "ViewJsAsEntity";
                this.run = "ViewJsRunEntity";
                this.total = "ViewJsTotalEntity";
                break;
            default:
                break;
        }
    }

}
