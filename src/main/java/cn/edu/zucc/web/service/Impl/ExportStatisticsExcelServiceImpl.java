package cn.edu.zucc.web.service.Impl;

import cn.edu.zucc.core.util.WriteExcel;
import cn.edu.zucc.web.dao.RunMapper;
import cn.edu.zucc.web.model.ViewRun;
import cn.edu.zucc.web.service.ExportStatisticsExcelService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zxy on 12/4/2016.
 */
@Service("exportStatisticsExcelService")
public class ExportStatisticsExcelServiceImpl implements ExportStatisticsExcelService {

    private static final Log logger = LogFactory.getLog(ExportStatisticsExcelServiceImpl.class);

    @Resource
    private RunMapper runMapper;

    @Override
    public boolean selectAndExport() {
        String path = getPath();
        List<ViewRun> list = runMapper.selectTodayRuns();
        WriteExcel writeExcel = new WriteExcel();
        String file = writeExcel.createRunExcel(list, path);
        logger.info("Export excel at " + System.currentTimeMillis() + " succeed!");
        return file != null && !"".equals(file);
    }

    private String getPath() {
        String os = System.getProperty("os.name");
        if ("Windows 10".equals(os) || "Windows 7".equals(os)) {
            return "E:\\Run Data\\";
        } else {
            String currentUser = System.getProperty("user.name");
            return "/home/" + currentUser + "/";
        }
    }

}
