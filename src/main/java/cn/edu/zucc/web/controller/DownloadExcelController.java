package cn.edu.zucc.web.controller;

import cn.edu.zucc.web.security.RoleSign;
import cn.edu.zucc.web.service.DownloadExcelService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * Created by zxy on 12/7/2016.
 */
@Controller("downloadExcelController")
public class DownloadExcelController {

    private static final Log logger = LogFactory.getLog(DownloadExcelController.class);

    @Resource
    private DownloadExcelService downloadExcelService;

    @RequestMapping(value = "/admin/getExcelPages", method = RequestMethod.GET)
    @RequiresRoles(value = RoleSign.ADMIN)
    public
    @ResponseBody
    String getRunPage() {
        Integer page = downloadExcelService.getPage();
        if (page == null) {
            page = 1;
        }
        if (page <= 50) {
            page = 1;
        } else {
            page /= 50;
        }
        return "{\"page\":" + page + "}";
    }

    @RequestMapping(value = "/admin/excels", method = RequestMethod.GET)
    @RequiresRoles(RoleSign.ADMIN)
    public ModelAndView loadExcels(Model model, @RequestParam("page") int page) {
        logger.info("Receive load excel list request.");
        if (page <= 0) {
            return new ModelAndView("admin/excels?page=1");
        }
        int size = 50;
        List<String> excelList = downloadExcelService.getExcels((page - 1) * size, size);
        model.addAttribute("excelList", excelList);
        return new ModelAndView("admin/excels");
    }

    @RequestMapping(value = "/admin/excel",method = RequestMethod.GET)
    @RequiresRoles(RoleSign.ADMIN)
    public ModelAndView download(@RequestParam("name") String name,HttpServletResponse response){
        String fileName = downloadExcelService.getFilePath(name);
        File file = new File(fileName);
        if (file.exists()) {
            logger.info("1");
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            response.addHeader("Content-Disposition", "attachment;filename=" + name);
            byte[] buffer = new byte[1024];
            logger.info("2");
            try {
                FileInputStream fis = new FileInputStream(file);
                BufferedInputStream bis = new BufferedInputStream(fis);
                OutputStream os = response.getOutputStream();
                int i = bis.read(buffer);
                logger.info("3");
                while (i != -1) {
                    os.write(buffer, 0, i);
                    i = bis.read(buffer);
                }
                logger.info("4");
                os.flush();
                os.close();
                fis.close();
                bis.close();
                return new ModelAndView("admin/excels?page=1");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new ModelAndView("admin/excels?page=1");
    }
}
