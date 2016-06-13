package cn.edu.zucc.serviceImpl;

import cn.edu.zucc.dao.RunDao;
import cn.edu.zucc.entity.BeanrunEntity;
import cn.edu.zucc.service.RunService;
import com.googlecode.ehcache.annotations.TriggersRemove;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by zxy on 6/13/2016.
 */
@Service("runService")
public class RunServiceImpl implements RunService {

    @Autowired
    private RunDao runDao;

    @TriggersRemove(cacheName = "runServiceCache",removeAll = true)
    @Override
    public Boolean addRun(String sno, String stime, String etime) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date sdate = sdf.parse(stime);
            Date edate = sdf.parse(etime);
            BeanrunEntity beanrunEntity = new BeanrunEntity();
            beanrunEntity.setSno(sno);
            beanrunEntity.setStarttime(sdate);
            beanrunEntity.setEndtime(edate);
            beanrunEntity.setMeter(2000.0);
            return runDao.addRun(beanrunEntity);
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
