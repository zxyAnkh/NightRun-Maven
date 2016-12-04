package cn.edu.zucc.web.form;

/**
 * Created by zxy on 2016/7/8.
 * @author zxyAnkh
 * @since  2016-07-08
 */
public class UserInfoForm {
    private String userno;
    private String username;
    private String oldpassword;
    private String newpassword1;
    private String newpassword2;

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

    public String getOldpassword() {
        return oldpassword;
    }

    public void setOldpassword(String oldpassword) {
        this.oldpassword = oldpassword;
    }

    public String getNewpassword1() {
        return newpassword1;
    }

    public void setNewpassword1(String newpassword1) {
        this.newpassword1 = newpassword1;
    }

    public String getNewpassword2() {
        return newpassword2;
    }

    public void setNewpassword2(String newpassword2) {
        this.newpassword2 = newpassword2;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("user no = ");
        sb.append(userno);
        sb.append("; user name = ");
        sb.append(username);
        sb.append("; old password = ");
        sb.append(oldpassword);
        sb.append("; new password = ");
        sb.append(newpassword1);
        sb.append("; new password = ");
        sb.append(newpassword2);
        return sb.toString();
    }
}
