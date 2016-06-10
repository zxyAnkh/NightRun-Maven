package cn.edu.zucc.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by zxy on 6/10/2016.
 */
@Entity
@Table(name = "beanrun", schema = "night_run", catalog = "")
public class BeanrunEntity {
    private int rId;
    private double meter;
    private Date starttime;
    private Date endtime;
    private String sno;

    @Id
    @Column(name = "r_id")
    public int getrId() {
        return rId;
    }

    public void setrId(int rId) {
        this.rId = rId;
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
    @Column(name = "sno")
    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BeanrunEntity that = (BeanrunEntity) o;

        if (rId != that.rId) return false;
        if (Double.compare(that.meter, meter) != 0) return false;
        if (starttime != null ? !starttime.equals(that.starttime) : that.starttime != null) return false;
        if (endtime != null ? !endtime.equals(that.endtime) : that.endtime != null) return false;
        if (sno != null ? !sno.equals(that.sno) : that.sno != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = rId;
        temp = Double.doubleToLongBits(meter);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (starttime != null ? starttime.hashCode() : 0);
        result = 31 * result + (endtime != null ? endtime.hashCode() : 0);
        result = 31 * result + (sno != null ? sno.hashCode() : 0);
        return result;
    }
}
