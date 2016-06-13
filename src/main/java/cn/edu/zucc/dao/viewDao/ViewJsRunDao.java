package cn.edu.zucc.dao.viewDao;

import cn.edu.zucc.entity.ViewJsRunEntity;

import java.util.List;

/**
 * Created by zxy on 6/13/2016.
 */
public interface ViewJsRunDao {
    List<ViewJsRunEntity> loadAdminRun(String ano);
    List<ViewJsRunEntity> findRun(String type, String keyword);
    List<ViewJsRunEntity> loadUserRun(String sno);
}
