package cn.edu.zucc.web.service;

import java.util.List;

/**
 * Created by zxy on 12/7/2016.
 */
public interface DownloadExcelService {

    List<String> getExcels(int start, int offset);

    String getFilePath(String name);

}
