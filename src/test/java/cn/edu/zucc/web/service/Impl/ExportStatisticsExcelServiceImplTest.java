package cn.edu.zucc.web.service.Impl;

import cn.edu.zucc.core.feature.test.TestSupport;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zxy on 12/4/2016.
 */
public class ExportStatisticsExcelServiceImplTest extends TestSupport {

    @Test
    public void getPath(){
        String os = System.getProperty("os.name");
        String currentUser = System.getProperty("user.name");
        System.out.println(os + "   " + currentUser);
    }

}