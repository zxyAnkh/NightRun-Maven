package cn.edu.zucc.serviceImpl;

import cn.edu.zucc.dao.NoticeDao;
import cn.edu.zucc.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zxy on 6/12/2016.
 */
@Service("noticeService")
public class NoticeServiceImpl implements NoticeService{

    @Autowired
    private NoticeDao noticeDao;

}
