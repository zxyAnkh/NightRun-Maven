package cn.edu.zucc.web.service;

import cn.edu.zucc.web.model.User;
import cn.edu.zucc.web.model.ViewRun;
import cn.edu.zucc.web.model.ViewTotal;

import java.util.List;

/**
 * Created by zxy on 11/20/2016.
 */
public interface SearchService {
    List<User> selectByKeyword(String keyword, int start, int size);

    List<ViewRun> selectRunsByUserno(String keyword, int start, int size);

    ViewTotal selectRunByUserno(String keyword);
}
