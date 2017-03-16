package cn.edu.zucc.web.service.Impl;

import cn.edu.zucc.web.dao.RunMapper;
import cn.edu.zucc.web.model.Run;
import cn.edu.zucc.web.model.ViewRun;
import cn.edu.zucc.web.model.ViewTotal;
import cn.edu.zucc.web.service.RunService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zxy on 2016/7/7.
 * @author zxyAnkh
 * @since  2016-07-07
 */
@Service("runService")
public class RunServiceImpl  implements RunService{

    @Resource
    private RunMapper runMapper;

    @Override
    public List<ViewRun> selectRunsByUserid(int userid) {
        return runMapper.selectRunsByUserid(userid);
    }

    @Override
    public ViewTotal selectRunByUserid(int userid) {
        return runMapper.selectRunByUserid(userid);
    }

    @Override
    public int insert(Run run) {
        return runMapper.insert(run);
    }
}
