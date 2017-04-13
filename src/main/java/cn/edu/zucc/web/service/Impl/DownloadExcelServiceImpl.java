package cn.edu.zucc.web.service.Impl;

import cn.edu.zucc.web.service.DownloadExcelService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zxy on 12/7/2016.
 */
@Service("downloadExcelService")
public class DownloadExcelServiceImpl implements DownloadExcelService {

    @Override
    public List<String> getExcels(int start, int offset) {
        String path = getPath();
        File file = new File(path);
        List<String> result = new ArrayList<String>();
        if (file.exists()) {
            String[] files = file.list();
            if (files != null && files.length != 0) {
                for (int i = start; i < start + offset && i < files.length; i++) {
                    if (files[i] != null && !"".equals(files[i])) {
                        result.add(files[i]);
                    } else {
                        break;
                    }
                }
            }
        }
        return result;
    }

    @Override
    public String getFilePath(String name) {
        String path = getPath();
        return path + name;
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
