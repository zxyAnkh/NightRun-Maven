package cn.edu.zucc.serviceImpl;

import cn.edu.zucc.dao.UserDao;
import cn.edu.zucc.entity.BeanrunEntity;
import cn.edu.zucc.entity.ViewJsRunEntity;
import cn.edu.zucc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by zxy on 5/14/2016.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    // success: true
    @Override
    public Boolean doLogin(String sno, String pwd) {
        return userDao.doLogin(sno, pwd) != null;
    }

    @Override
    public List<Map<String, String>> loadRun(String sno) {
        List<Map<String, String>> mapList = new ArrayList<Map<String, String>>();
        List<ViewJsRunEntity> list = userDao.loadRun(sno);
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

    @Override
    public Boolean addRun(String sno, String stime, String etime) {
        try {
            if (userDao.findByNo(sno, 1) != null) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date sdate = sdf.parse(stime);
                Date edate = sdf.parse(etime);
                BeanrunEntity beanrunEntity = new BeanrunEntity();
                beanrunEntity.setSno(sno);
                beanrunEntity.setStarttime(sdate);
                beanrunEntity.setEndtime(edate);
                beanrunEntity.setMeter(2000.0);
                return userDao.addRun(beanrunEntity);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
