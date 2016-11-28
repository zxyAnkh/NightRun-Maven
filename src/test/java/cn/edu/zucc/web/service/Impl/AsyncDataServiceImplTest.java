package cn.edu.zucc.web.service.Impl;

import cn.edu.zucc.core.feature.test.TestSupport;
import cn.edu.zucc.web.service.AsyncDataService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by zxy on 11/20/2016.
 */
public class AsyncDataServiceImplTest extends TestSupport {

    @Autowired
    private AsyncDataService asyncDataService;

    @Test
    public void getUserData() throws Exception {
        System.out.println(asyncDataService.getUserData("31301100"));
    }

}