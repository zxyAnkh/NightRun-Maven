package cn.edu.zucc.web.service.Impl;

import cn.edu.zucc.web.dao.RunMapper;
import cn.edu.zucc.web.dao.UserMapper;
import cn.edu.zucc.web.json.RunDataPojo;
import cn.edu.zucc.web.model.Run;
import cn.edu.zucc.web.service.AddRunDataService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by zxy on 12/3/2016.
 */
@Service("addRunDataService")
public class AddRunDataServiceImpl implements AddRunDataService {

    @Resource
    private RunMapper runMapper;
    @Resource
    private UserMapper userMapper;

    @Override
    public boolean insert(RunDataPojo pojo) {
        if (600L <= (pojo.getEtime() - pojo.getStime()) && (pojo.getEtime() - pojo.getStime()) <= 1200L) {
            Run run = new Run();
            run.setMeter(pojo.getMeter());
            run.setEndtime(timeStampToDate(pojo.getEtime()));
            run.setStarttime(timeStampToDate(pojo.getStime()));
            int id = userMapper.selectByUserno(pojo.getSno()).getId();
            run.setUserid(id);
            return runMapper.insert(run) == 1;
        }
        return false;
    }

    private Date timeStampToDate(long time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time * 1000L);
        return calendar.getTime();
    }
}
