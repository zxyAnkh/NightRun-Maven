package cn.edu.zucc.form;

import java.util.Date;

/**
 * Created by zxy on 6/3/2016.
 */
public class BeanuserForm {
    private String no;
    private String name;
    private String pwd;
    private int branch;
    private int grade;
    private Date addtime;
    public BeanuserForm(String no, String name){
        this.no = no;
        this.name = name;
        this.pwd = "123456";
        this.branch = Integer.parseInt(no.substring(4,5));
        this.grade = Integer.parseInt(no.substring(1,3));
        this.addtime = new Date();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getBranch() {
        return branch;
    }

    public void setBranch(int branch) {
        this.branch = branch;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

}
