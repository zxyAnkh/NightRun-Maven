package cn.edu.zucc.serviceImpl;

import cn.edu.zucc.dao.viewDao.ViewJsAsDao;
import cn.edu.zucc.dao.viewDao.ViewJsRunDao;
import cn.edu.zucc.dao.viewDao.ViewJsTotalDao;
import cn.edu.zucc.entity.ViewJsAsEntity;
import cn.edu.zucc.entity.ViewJsRunEntity;
import cn.edu.zucc.entity.ViewJsTotalEntity;
import cn.edu.zucc.service.ViewService;
import com.googlecode.ehcache.annotations.TriggersRemove;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zxy on 6/13/2016.
 */
@Service("viewService")
public class ViewServiceImpl implements ViewService {

    @Autowired
    private ViewJsAsDao viewJsAsDao;
    @Autowired
    private ViewJsRunDao viewJsRunDao;
    @Autowired
    private ViewJsTotalDao viewJsTotalDao;

    @TriggersRemove(cacheName = "viewServiceCache",removeAll = true)
    @Override
    public List<ViewJsAsEntity> loadUser(String ano, Boolean isAll) {
        return viewJsAsDao.loadUser(ano, isAll);
    }

    @TriggersRemove(cacheName = "viewServiceCache",removeAll = true)
    @Override
    public List<ViewJsRunEntity> loadRun(String ano, int branch) {
        return viewJsRunDao.loadAdminRun(ano);
    }

    @TriggersRemove(cacheName = "viewServiceCache",removeAll = true)
    @Override
    public List<Map<String, String>> loadRun(String sno) {
        List<Map<String, String>> mapList = new ArrayList<Map<String, String>>();
        List<ViewJsRunEntity> list = viewJsRunDao.loadUserRun(sno);
        for (ViewJsRunEntity viewJsRunEntity : list) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("sid", String.valueOf(viewJsRunEntity.getsId()));
            map.put("sno", viewJsRunEntity.getSno());
            map.put("sname", viewJsRunEntity.getSname());
            map.put("meter", String.valueOf(viewJsRunEntity.getMeter()));
            map.put("time", String.valueOf(viewJsRunEntity.getTime()));
            map.put("starttime", String.valueOf(viewJsRunEntity.getStarttime()));
            map.put("endtime", String.valueOf(viewJsRunEntity.getEndtime()));
            mapList.add(map);
        }
        return mapList;
    }

    @TriggersRemove(cacheName = "viewServiceCache",removeAll = true)
    @Override
    public List<ViewJsRunEntity> findRun(String type, String keyword, int branch) {
        if (keyword != null && !"".equals(keyword)) {
            return viewJsRunDao.findRun(type, keyword);
        }
        return null;
    }

    @TriggersRemove(cacheName = "viewServiceCache",removeAll = true)
    @Override
    public List<ViewJsAsEntity> findUser(String keyword, int branch) {
        if (keyword != null && !"".equals(keyword))
            return viewJsAsDao.findUser(keyword);
        return null;
    }

//    @Cacheable(value = "viewServiceCache")
    @Override
    public List<ViewJsTotalEntity> findTotal(String keyword, int branch) {
        if (keyword != null && !"".equals(keyword))
            return viewJsTotalDao.findTotal(keyword);
        return null;
    }
}
