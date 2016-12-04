package cn.edu.zucc.web.task;

import cn.edu.zucc.web.service.ExportStatisticsExcelService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by zxy on 12/4/2016.
 */
@Component("exportStatisticsExcelTask")
public class ExportStatisticsExcelTask {

    private static final Log logger = LogFactory.getLog(ExportStatisticsExcelTask.class);

    @Autowired
    private ExportStatisticsExcelService exportStatisticsExcelService;

    public void execute(){
        logger.debug("Start execute export statistics excel job.");
        boolean bool = exportStatisticsExcelService.selectAndExport();
        logger.debug("Finish execute export statistics excel job. result = " + bool);
    }

}
