package cn.edu.zucc.web.json;

/**
 * Created by zxy on 3/31/2017.
 */
public class AddRunRequest {
    private String no;
    private String meter;
    private String starttime;
    private String endtime;
    private String phoneuid;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getMeter() {
        return meter;
    }

    public void setMeter(String meter) {
        this.meter = meter;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getPhoneuid() {
        return phoneuid;
    }

    public void setPhoneuid(String phoneuid) {
        this.phoneuid = phoneuid;
    }
}
