package cn.edu.zucc.web.service.Impl;

import cn.edu.zucc.web.dao.RunMapper;
import cn.edu.zucc.web.dao.UserMapper;
import cn.edu.zucc.web.model.User;
import cn.edu.zucc.web.model.ViewRun;
import cn.edu.zucc.web.model.ViewTotal;
import cn.edu.zucc.web.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zxy on 11/20/2016.
 */
@Service("searchService")
public class SearchServiceImpl implements SearchService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RunMapper runMapper;

    @Override
    public List<User> selectByKeyword(String keyword, int start, int size) {
        if (null == keyword || "".equals(keyword)) {
            return new ArrayList<User>();
        }
        if (start < 0 || size < 0) {
            return new ArrayList<User>();
        }
        return userMapper.selectByKeywordPage("%" + keyword + "%", start, start + size);
    }

    @Override
    public List<ViewRun> selectRunsByUserno(String keyword, int start, int size) {
        if (null == keyword || "".equals(keyword)) {
            return new ArrayList<ViewRun>();
        }

        return runMapper.selectRunsByUserNoPage(keyword, start, start + size);
    }

    @Override
    public ViewTotal selectRunByUserno(String keyword) {
        return runMapper.selectRunByUserno(keyword);
    }
}