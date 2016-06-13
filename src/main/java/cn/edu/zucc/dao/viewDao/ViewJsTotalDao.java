package cn.edu.zucc.dao.viewDao;

import cn.edu.zucc.entity.ViewJsTotalEntity;

import java.util.List;

/**
 * Created by zxy on 6/13/2016.
 */
public interface ViewJsTotalDao {
    List<ViewJsTotalEntity> findTotal(String keyword);
}
