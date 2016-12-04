package cn.edu.zucc.web.json;

import java.util.List;

/**
 * Created by zxy on 11/29/2016.
 */
public class StudentNoPojo {

    private List<String> nos;

    public List<String> getNos() {
        return nos;
    }

    public void setNos(List<String> nos) {
        this.nos = nos;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String no : nos) {
            sb.append("no");
            sb.append(no);
            sb.append(";");
        }
        return sb.toString();
    }
}
