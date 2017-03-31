package cn.edu.zucc.web.service.Impl;

import cn.edu.zucc.web.dao.RunMapper;
import cn.edu.zucc.web.json.RunDataPojo;
import cn.edu.zucc.web.model.ViewRun;
import cn.edu.zucc.web.service.LoadRunDataService;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by zxy on 11/19/2016.
 */
@Service("loadRunDataServiceImpl")
public class LoadRunDataServiceImpl implements LoadRunDataService {

    @Resource
    private RunMapper runMapper;

    @Override
    public List<ViewRun> getRunDataByPageSize(int start, int offset) {
        if (start < 0 || offset < 0) {
            return new ArrayList<ViewRun>();
        }
        List<ViewRun> list = runMapper.selectRunsByPage(start, start + offset);
        Collections.sort(list, new Comparator<ViewRun>() {
            @Override
            public int compare(ViewRun o1, ViewRun o2) {
                return o2.getStarttime().compareTo(o1.getStarttime());
            }
        });
        return list;
    }

    @Override
    public Integer getPage() {
        return runMapper.getDataLength();
    }

    @Override
    public String getRunDataByUserNo(String no) {
        if (no == null || "".equals(no)) {
            return "{\"runDataPojos\":\"\"}";
        }
        Gson gson = new Gson();
        List<ViewRun> viewRuns = runMapper.selectRunsByUserNo(no);
        List<RunDataPojo> runDataPojos = new ArrayList<RunDataPojo>();
        Map<String, List<RunDataPojo>> map = new HashMap<String, List<RunDataPojo>>();
        if (viewRuns != null) {
            for (ViewRun viewRun : viewRuns) {
                RunDataPojo pojo = new RunDataPojo();
                pojo.setId(viewRun.getRid());
                pojo.setSno(viewRun.getUserno());
                pojo.setName(viewRun.getUsername());
                pojo.setMeter(viewRun.getMeter());
                pojo.setTime(viewRun.getTime());
                pojo.setStime(viewRun.getStarttime().getTime());
                pojo.setEtime(viewRun.getEndtime().getTime());
                runDataPojos.add(pojo);
            }
        }
        map.put("data", runDataPojos);
        return gson.toJson(map);
    }
}
