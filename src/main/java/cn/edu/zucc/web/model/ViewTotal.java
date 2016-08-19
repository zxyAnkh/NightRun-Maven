package cn.edu.zucc.web.model;

import java.io.Serializable;

/**
 * Created by zxy on 2016/7/7.
 */
public class ViewTotal implements Serializable{
    private int uid;
    private String userno;
    private String username;
    private int usergrade;
    private int userbranch;
    private int count;
    private double summeter;
    private long sumtime;

    public int getUid() {
        return uid;
    }

    public String getUserno() {
        return userno;
    }

    public void setUserno(String userno) {
        this.userno = userno;
    }

    public void setUid(int uid) {
        this.uid = uid;
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getSummeter() {
        return summeter;
    }

    public void setSummeter(double summeter) {
        this.summeter = summeter;
    }

    public long getSumtime() {
        return sumtime;
    }

    public void setSumtime(long sumtime) {
        this.sumtime = sumtime;
    }

    public String getUsername() {
        return username;
    }
}
