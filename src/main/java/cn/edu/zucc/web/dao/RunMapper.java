package cn.edu.zucc.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.edu.zucc.core.generic.GenericDao;
import cn.edu.zucc.web.model.Run;
import cn.edu.zucc.web.model.ViewRun;
import cn.edu.zucc.web.model.ViewTotal;

@Repository("runMapper")
public interface RunMapper extends GenericDao<Run, Integer> {

    /**
     * 添加夜跑记录
     *
     * @param record
     * @return
     */
    int insert(Run record);

    /**
     * 通过用户id查找用户夜跑的统计
     *
     * @param userid
     * @return
     */
    ViewTotal selectRunByUserid(int userid);

    ViewTotal selectRunByUserno(String no);

    /**
     * 通过用户id查找用户的夜跑记录
     *
     * @param userid
     * @return
     */
    List<ViewRun> selectRunsByUserid(int userid);

    /**
     * 读取所有夜跑记录
     *
     * @return
     */
    List<ViewRun> selectRuns();

    List<ViewRun> selectRunsByPage(@Param("start") int start, @Param("end") int end);

    List<ViewRun> selectRunsByUserNo(String userno);

    List<ViewRun> selectRunsByUserNoPage(@Param("no") String no, @Param("start") int start, @Param("end") int end);
}
