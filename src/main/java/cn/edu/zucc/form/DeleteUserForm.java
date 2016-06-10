package cn.edu.zucc.form;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zxy on 6/7/2016.
 */
public class DeleteUserForm {
    private String snolist;

    public List<String> getSnolist() {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < snolist.length(); i += 8) {
            String str = snolist.substring(i, i + 8);
            list.add(str);
        }
        return list;
    }

    public void setSnolist(String snolist) {
        this.snolist = snolist;
    }
}
