package cn.edu.zucc.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by zxy on 5/16/2016.
 */
@Entity
@Table(name = "view_js_total", schema = "night_run", catalog = "")
public class ViewJsTotalEntity implements Serializable{
    private static final long serialVersionUID = 211L;
    private int sId;
    private String sno;
    private int sgrade;
    private long count;
    private Double summeter;
    private Long sumtime;

    @Id
    @Column(name = "s_id")
    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    @Id
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
    @Column(name = "count")
    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    @Basic
    @Column(name = "summeter")
    public Double getSummeter() {
        return summeter;
    }

    public void setSummeter(Double summeter) {
        this.summeter = summeter;
    }

    @Basic
    @Column(name = "sumtime")
    public Long getSumtime() {
        return sumtime;
    }

    public void setSumtime(Long sumtime) {
        this.sumtime = sumtime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ViewJsTotalEntity that = (ViewJsTotalEntity) o;

        if (sId != that.sId) return false;
        if (sgrade != that.sgrade) return false;
        if (count != that.count) return false;
        if (sno != null ? !sno.equals(that.sno) : that.sno != null) return false;
        if (summeter != null ? !summeter.equals(that.summeter) : that.summeter != null) return false;
        if (sumtime != null ? !sumtime.equals(that.sumtime) : that.sumtime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sId;
        result = 31 * result + (sno != null ? sno.hashCode() : 0);
        result = 31 * result + sgrade;
        result = 31 * result + (int) (count ^ (count >>> 32));
        result = 31 * result + (summeter != null ? summeter.hashCode() : 0);
        result = 31 * result + (sumtime != null ? sumtime.hashCode() : 0);
        return result;
    }
}
