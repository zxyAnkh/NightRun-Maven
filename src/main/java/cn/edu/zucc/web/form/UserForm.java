package cn.edu.zucc.web.form;

/**
 * Created by zxy on 2016/7/8.
 * @author zxyAnkh
 * @since 2016-07-08
 */
public class UserForm {
    private String userno;
    private String username;

    public String getUserno() {
        return userno;
    }

    public void setUserno(String userno) {
        this.userno = userno;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String uername) {
        this.username = uername;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("student no = ");
        sb.append(userno);
        sb.append("; student name = ");
        sb.append(username);
        return sb.toString();
    }
}
