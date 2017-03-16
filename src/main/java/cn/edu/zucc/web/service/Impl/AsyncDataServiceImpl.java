package cn.edu.zucc.web.service.Impl;

import cn.edu.zucc.web.dao.RunMapper;
import cn.edu.zucc.web.dao.UserMapper;
import cn.edu.zucc.web.model.User;
import cn.edu.zucc.web.model.ViewRun;
import cn.edu.zucc.web.model.ViewTotal;
import cn.edu.zucc.web.service.AsyncDataService;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 * Created by zxy on 11/20/2016.
 */
@Service("asyncDataSerivce")
public class AsyncDataServiceImpl implements AsyncDataService {

    @Resource
    private RunMapper runMapper;
    @Resource
    private UserMapper userMapper;

    @Override
    public String getUserData(String userno) {
        Gson gson = new Gson();
        User user = userMapper.selectByUserno(userno);
        user.setPassword(null);
        List<ViewRun> viewRuns = runMapper.selectRunsByUserNo(userno);
        ViewTotal viewTotal = runMapper.selectRunByUserno(userno);

        StringBuilder sb = new StringBuilder();
        sb.append(gson.toJson(user));
        sb.deleteCharAt(sb.length() - 1);
        sb.append(",\"count\":");
        sb.append(viewTotal.getCount());
        sb.append(",\"summeter\":");
        sb.append(viewTotal.getSummeter());
        sb.append(",\"sumtime\":");
        sb.append(viewTotal.getSumtime());
        sb.append(",");
        sb.append(gson.toJson(viewRuns));
        sb.append("}");
        return sb.toString();
    }
}
