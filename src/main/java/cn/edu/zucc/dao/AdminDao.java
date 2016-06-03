package cn.edu.zucc.dao;

import cn.edu.zucc.entity.BeanadminEntity;
import cn.edu.zucc.entity.BeanuserEntity;
import cn.edu.zucc.entity.ViewJsAsEntity;
import cn.edu.zucc.entity.ViewJsRunEntity;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by zxy on 5/12/2016.
 */
public interface AdminDao {
    BeanadminEntity findByNo(String ano);
    List<ViewJsAsEntity> loadUser(String ano, Boolean isAll);
    List<ViewJsRunEntity> loadRun(String ano, int branch, Boolean isAll);
    List<ViewJsRunEntity> fuzzyQuery(String type, String keyword, int branch, Boolean isAll);
    Boolean modify(BeanadminEntity beanadminEntity);
}
