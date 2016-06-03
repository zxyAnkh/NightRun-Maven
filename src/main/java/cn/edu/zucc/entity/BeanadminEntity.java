package cn.edu.zucc.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by zxy on 5/12/2016.
 */
@Entity
@Table(name = "beanadmin", schema = "night_run", catalog = "")
public class BeanadminEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    private int aId;
    @NotNull(message = "账号不能为空")
    @Size(max = 8, min = 1, message = "账号长度不能超过8")
    private String ano;
    private String aname;
    @NotNull(message = "密码不能为空")
    @Size(min = 1, max = 20, message = "账号密码长度不能超过20")
    private String apwd;
    private int abranch;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "a_id")
    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
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
    @Column(name = "aname")
    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    @Basic
    @Column(name = "apwd")
    public String getApwd() {
        return apwd;
    }

    public void setApwd(String apwd) {
        this.apwd = apwd;
    }

    @Basic
    @Column(name = "abranch")
    public int getAbranch() {
        return abranch;
    }

    public void setAbranch(int abranch) {
        this.abranch = abranch;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BeanadminEntity that = (BeanadminEntity) o;

        if (aId != that.aId) return false;
        if (abranch != that.abranch) return false;
        if (ano != null ? !ano.equals(that.ano) : that.ano != null) return false;
        if (aname != null ? !aname.equals(that.aname) : that.aname != null) return false;
        if (apwd != null ? !apwd.equals(that.apwd) : that.apwd != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = aId;
        result = 31 * result + (ano != null ? ano.hashCode() : 0);
        result = 31 * result + (aname != null ? aname.hashCode() : 0);
        result = 31 * result + (apwd != null ? apwd.hashCode() : 0);
        result = 31 * result + abranch;
        return result;
    }
}
