package cn.edu.zucc.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by zxy on 5/16/2016.
 */
@Entity
@Table(name = "view_js_run", schema = "night_run", catalog = "")
public class ViewJsRunEntity implements Serializable{
    private static final long serialVersionUID = 21L;
    private int sId;
    private int rId;
    private String sno;
    private String sname;
    private int sgrade;
    private double meter;
    private long time;
    private Date starttime;
    private Date endtime;

    @Id
    @Column(name = "s_id")
    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    @Id
    @Column(name = "r_id")
    public int getrId() {
        return rId;
    }

    public void setrId(int rId) {
        this.rId = rId;
    }

    @Basic
    @Column(name = "sno")
    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    @Basic
    @Column(name = "sgrade")
    public int getSgrade() {
        return sgrade;
    }

    public void setSgrade(int sgrade) {
        this.sgrade = sgrade;
    }

    @Basic
    @Column(name = "meter")
    public double getMeter() {
        return meter;
    }

    public void setMeter(double meter) {
        this.meter = meter;
    }

    @Basic
    @Column(name = "time")
    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ViewJsRunEntity that = (ViewJsRunEntity) o;

        if (sId != that.sId) return false;
        if (rId != that.rId) return false;
        if (sgrade != that.sgrade) return false;
        if (Double.compare(that.meter, meter) != 0) return false;
        if (time != that.time) return false;
        if (sno != null ? !sno.equals(that.sno) : that.sno != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = sId;
        result = 31 * result + rId;
        result = 31 * result + (sno != null ? sno.hashCode() : 0);
        result = 31 * result + sgrade;
        temp = Double.doubleToLongBits(meter);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (int) (time ^ (time >>> 32));
        return result;
    }

    @Basic
    @Column(name = "starttime")
    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    @Basic
    @Column(name = "endtime")
    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    @Basic
    @Column(name = "sname")
    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }
}
