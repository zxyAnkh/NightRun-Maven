package cn.edu.zucc.web.service.Impl;

import cn.edu.zucc.core.feature.test.TestSupport;
import cn.edu.zucc.web.service.LoadRunDataService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by zxy on 2/27/2017.
 */
public class LoadRunDataServiceImplTest extends TestSupport{

    @Autowired
    private LoadRunDataService loadRunDataService;
    @Test
    public void getRunDataByUserNo() throws Exception {
        String json = loadRunDataService.getRunDataByUserNo("31301100");
        System.out.println(json);
    }

}