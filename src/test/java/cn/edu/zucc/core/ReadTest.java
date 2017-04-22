package cn.edu.zucc.core;

import cn.edu.zucc.core.feature.test.TestSupport;
import cn.edu.zucc.core.util.ReadExcel;
import cn.edu.zucc.web.form.UserForm;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * Created by zxy on 4/22/2017.
 */
public class ReadTest extends TestSupport {

    @Test
    public void readTest() throws IOException {
        ReadExcel re = new ReadExcel();
        List<UserForm> list = re.readExcel("C:\\Users\\zxy\\Desktop\\新增学生.xls");
        for (UserForm uf : list) {
            System.out.println(uf.toString());
        }
    }
}
