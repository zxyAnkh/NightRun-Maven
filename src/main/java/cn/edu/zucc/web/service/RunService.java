package cn.edu.zucc.web.service;

import cn.edu.zucc.core.generic.GenericService;
import cn.edu.zucc.web.model.Run;
import cn.edu.zucc.web.model.ViewRun;
import cn.edu.zucc.web.model.ViewTotal;
import org.springframework.web.servlet.View;

import java.util.List;

/**
 * 夜跑数据相关处理
 * Created by zxy on 2016/7/7.
 * @author zxyAnkh
 * @since  2016-07-07
 */
public interface RunService extends GenericService<Run,Integer>{

    /**
     * 添加夜跑记录
     * @param record
     * @return
     */
    int insert(Run record);

    /**
     * 通过用户id 查询用户夜跑记录
     *
     * @param userid
     * @return
     */
    List<ViewRun> selectRunsByUserid(int userid);

    /**
     * 通过用户id 查询用户夜跑统计数据
     * @param userid
     * @return
     */
    ViewTotal selectRunByUserid(int userid);

    /**
     * 读取所有夜跑记录
     * @return
     */
    List<ViewRun> selectRuns();
}
