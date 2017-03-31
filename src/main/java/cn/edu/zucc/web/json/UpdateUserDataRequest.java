package cn.edu.zucc.web.json;


/**
 * Created by zxy on 3/31/2017.
 */
public class UpdateUserDataRequest {
    private String no;
    private String oldpwd;
    private String newpwd;
    private String phoneuid;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getOldpwd() {
        return oldpwd;
    }

    public void setOldpwd(String oldpwd) {
        this.oldpwd = oldpwd;
    }

    public String getNewpwd() {
        return newpwd;
    }

    public void setNewpwd(String newpwd) {
        this.newpwd = newpwd;
    }

    public String getPhoneuid() {
        return phoneuid;
    }

    public void setPhoneuid(String phoneuid) {
        this.phoneuid = phoneuid;
    }
}
