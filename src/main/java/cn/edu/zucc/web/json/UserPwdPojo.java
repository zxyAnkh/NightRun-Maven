package cn.edu.zucc.web.json;

/**
 * Created by zxy on 3/3/2017.
 */
public class UserPwdPojo {

    private String no;
    private String oldPwd;
    private String newPwd;

    public UserPwdPojo() {
    }

    public UserPwdPojo(String no, String oldPwd, String newPwd) {
        this.no = no;
        this.oldPwd = oldPwd;
        this.newPwd = newPwd;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getOldPwd() {
        return oldPwd;
    }

    public void setOldPwd(String oldPwd) {
        this.oldPwd = oldPwd;
    }

    public String getNewPwd() {
        return newPwd;
    }

    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }

    @Override
    public String toString() {
        return "UserPwdPojo{" +
                "no='" + no + '\'' +
                ", oldPwd='" + oldPwd + '\'' +
                ", newPwd='" + newPwd + '\'' +
                '}';
    }
}
