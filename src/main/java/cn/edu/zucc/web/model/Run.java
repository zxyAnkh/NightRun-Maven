package cn.edu.zucc.web.model;

import java.io.Serializable;
import java.util.Date;

public class Run implements Serializable {
    private Integer id;

    private Double meter;

    private Date starttime;

    private Date endtime;

    private Integer userid;

    private Date rowCreateTime;

    private Date rowUpdateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getMeter() {
        return meter;
    }

    public void setMeter(Double meter) {
        this.meter = meter;
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

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Date getRowCreateTime() {
        return rowCreateTime;
    }

    public void setRowCreateTime(Date rowCreateTime) {
        this.rowCreateTime = rowCreateTime;
    }

    public Date getRowUpdateTime() {
        return rowUpdateTime;
    }

    public void setRowUpdateTime(Date rowUpdateTime) {
        this.rowUpdateTime = rowUpdateTime;
    }
}