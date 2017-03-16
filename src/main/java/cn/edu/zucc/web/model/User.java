package cn.edu.zucc.web.model;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private Integer id;

    private String userno;

    private String username;

    private String password;

    private String userbranch;

    private String usergrade;

    private String phoneuid;

    private Date addtime;

    private Date deltime;

    private Date rowCreateTime;

    private Date rowUpdateTime;

    public User() {
    }

    public User(String userno, String password) {
        this.userno = userno;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserno() {
        return userno;
    }

    public void setUserno(String userno) {
        this.userno = userno == null ? null : userno.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getUserbranch() {
        return userbranch;
    }

    public void setUserbranch(String userbranch) {
        this.userbranch = userbranch == null ? null : userbranch.trim();
    }

    public String getUsergrade() {
        return usergrade;
    }

    public void setUsergrade(String usergrade) {
        this.usergrade = usergrade == null ? null : usergrade.trim();
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public Date getDeltime() {
        return deltime;
    }

    public void setDeltime(Date deltime) {
        this.deltime = deltime;
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

    public String getInfo() {
        return "no=" + userno + ",name=" + username;
    }

    public String getPhoneuid() {
        return phoneuid;
    }

    public void setPhoneuid(String phoneuid) {
        this.phoneuid = phoneuid;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userno='" + userno + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userbranch='" + userbranch + '\'' +
                ", usergrade='" + usergrade + '\'' +
                ", phoneuid='" + phoneuid + '\'' +
                ", addtime=" + addtime +
                ", deltime=" + deltime +
                ", rowCreateTime=" + rowCreateTime +
                ", rowUpdateTime=" + rowUpdateTime +
                '}';
    }
}