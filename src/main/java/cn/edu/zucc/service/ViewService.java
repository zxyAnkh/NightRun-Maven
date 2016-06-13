package cn.edu.zucc.service;

import cn.edu.zucc.entity.ViewJsAsEntity;
import cn.edu.zucc.entity.ViewJsRunEntity;
import cn.edu.zucc.entity.ViewJsTotalEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by zxy on 6/13/2016.
 */
public interface ViewService {
    List<ViewJsAsEntity> loadUser(String ano, Boolean isAll);
    List<Map<String,String>> loadRun(String sno);
    List<ViewJsRunEntity> loadRun(String ano, int branch);
    List<ViewJsRunEntity> findRun(String type, String keyword, int branch);
    List<ViewJsAsEntity> findUser(String keyword, int branch);
    List<ViewJsTotalEntity> findTotal(String keyword, int branch);
}
