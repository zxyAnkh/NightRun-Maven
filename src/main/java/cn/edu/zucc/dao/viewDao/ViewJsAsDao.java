package cn.edu.zucc.dao.viewDao;

import cn.edu.zucc.entity.ViewJsAsEntity;

import java.util.List;

/**
 * Created by zxy on 6/13/2016.
 */
public interface ViewJsAsDao {
    List<ViewJsAsEntity> loadUser(String ano, Boolean isAll);
    List<ViewJsAsEntity> findUser(String keyword);
}
