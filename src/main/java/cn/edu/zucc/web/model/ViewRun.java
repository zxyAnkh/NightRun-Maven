package cn.edu.zucc.web.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by zxy on 2016/7/7.
 */
public class ViewRun implements Serializable {
    private int uid;
    private int rid;
    private String userno;
    private String username;
    private int usergrade;
    private int userbranch;
    private double meter;
    private long time;
    private Date starttime;
    private Date endtime;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getUserno() {
        return userno;
    }

    public void setUserno(String userno) {
        this.userno = userno;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getUsergrade() {
        return usergrade;
    }

    public void setUsergrade(int usergrade) {
        this.usergrade = usergrade;
    }

    public int getUserbranch() {
        return userbranch;
    }

    public void setUserbranch(int userbranch) {
        this.userbranch = userbranch;
    }

    public double getMeter() {
        return meter;
    }

    public void setMeter(double meter) {
        this.meter = meter;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }
}
