package cn.edu.zucc.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by zxy on 5/14/2016.
 */
@Entity
@Table(name = "view_js_as", schema = "night_run", catalog = "")
public class ViewJsAsEntity implements Serializable{
    private static final long serialVersionUID = 12L;
    private int aId;
    private int sId;
    private String ano;
    private String sno;
    private String sname;
    private int sgrade;
    private Date addtime;
    private Date deltime;

    @Id
    @Column(name = "a_id")
    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    @Id
    @Column(name = "s_id")
    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    @Basic
    @Column(name = "ano")
    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
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
    @Column(name = "sname")
    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
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
    @Column(name = "addtime")
    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    @Basic
    @Column(name = "deltime")
    public Date getDeltime() {
        return deltime;
    }

    public void setDeltime(Date deltime) {
        this.deltime = deltime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ViewJsAsEntity that = (ViewJsAsEntity) o;

        if (aId != that.aId) return false;
        if (sId != that.sId) return false;
        if (sgrade != that.sgrade) return false;
        if (ano != null ? !ano.equals(that.ano) : that.ano != null) return false;
        if (sno != null ? !sno.equals(that.sno) : that.sno != null) return false;
        if (sname != null ? !sname.equals(that.sname) : that.sname != null) return false;
        if (addtime != null ? !addtime.equals(that.addtime) : that.addtime != null) return false;
        if (deltime != null ? !deltime.equals(that.deltime) : that.deltime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = aId;
        result = 31 * result + sId;
        result = 31 * result + (ano != null ? ano.hashCode() : 0);
        result = 31 * result + (sno != null ? sno.hashCode() : 0);
        result = 31 * result + (sname != null ? sname.hashCode() : 0);
        result = 31 * result + sgrade;
        result = 31 * result + (addtime != null ? addtime.hashCode() : 0);
        result = 31 * result + (deltime != null ? deltime.hashCode() : 0);
        return result;
    }
}
