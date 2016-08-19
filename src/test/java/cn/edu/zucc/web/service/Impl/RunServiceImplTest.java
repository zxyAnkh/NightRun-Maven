package cn.edu.zucc.web.service.Impl;

import cn.edu.zucc.core.feature.test.TestSupport;
import cn.edu.zucc.web.model.Run;
import cn.edu.zucc.web.model.ViewRun;
import cn.edu.zucc.web.model.ViewTotal;
import cn.edu.zucc.web.service.RunService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.View;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by zxy on 2016/7/7.
 */
public class RunServiceImplTest extends TestSupport{

    @Autowired
    private RunService runService;

    @Test
    public void selectRunsByUserid() throws Exception {
        List<ViewRun> list = runService.selectRunsByUserid(9);
        for(ViewRun run:list)
            System.out.println(run.getStarttime());
    }

    @Test
    public void selectRunByUserid() throws Exception{
        ViewTotal viewTotal = runService.selectRunByUserid(9);
        System.out.println(viewTotal.getUserno());
    }
    @Test
    public void insert() throws Exception {

    }

    @Test
    public void delete() throws Exception{

    }

}