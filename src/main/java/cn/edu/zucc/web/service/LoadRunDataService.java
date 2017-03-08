package cn.edu.zucc.web.service;

import cn.edu.zucc.web.model.ViewRun;

import java.util.List;

/**
 * 读取跑步数据Service
 * Created by zxy on 11/19/2016.
 */
public interface LoadRunDataService {
    List<ViewRun> getRunDataByPageSize(int start, int offset);

    String getRunDataByUserNo(String no);

    Integer getPage();
}
