package cn.edu.zucc.web.model;

import java.io.Serializable;

public class Permission implements Serializable {
    private Integer id;

    private String permissionname;

    private String permissionsign;

    private String desription;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPermissionname() {
        return permissionname;
    }

    public void setPermissionname(String permissionname) {
        this.permissionname = permissionname == null ? null : permissionname.trim();
    }

    public String getPermissionsign() {
        return permissionsign;
    }

    public void setPermissionsign(String permissionsign) {
        this.permissionsign = permissionsign == null ? null : permissionsign.trim();
    }

    public String getDesription() {
        return desription;
    }

    public void setDesription(String desription) {
        this.desription = desription == null ? null : desription.trim();
    }
}