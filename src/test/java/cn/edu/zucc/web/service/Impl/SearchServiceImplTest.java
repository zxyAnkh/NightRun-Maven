package cn.edu.zucc.web.service.Impl;

import cn.edu.zucc.core.feature.test.TestSupport;
import cn.edu.zucc.web.model.User;
import cn.edu.zucc.web.model.ViewRun;
import cn.edu.zucc.web.model.ViewTotal;
import cn.edu.zucc.web.service.SearchService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by zxy on 11/20/2016.
 */
public class SearchServiceImplTest extends TestSupport{

    @Autowired
    private SearchService searchService;

    @Test
    public void selectByKeyword() throws Exception {
        List<User> list = searchService.selectByKeyword("3130",0,50);
        System.out.println(list.size());
    }

    @Test
    public void selectRunsByUserid() throws Exception {
        List<ViewRun> list = searchService.selectRunsByUserno("31301100",0,50);
        System.out.println(list.size());
    }

    @Test
    public void selectRunByUserid() throws Exception {
        ViewTotal viewTotal = searchService.selectRunByUserno("31301100");
        System.out.println(viewTotal.getUsername());
    }

}