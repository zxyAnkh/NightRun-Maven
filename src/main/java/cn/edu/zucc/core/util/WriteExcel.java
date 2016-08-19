package cn.edu.zucc.core.util;

import cn.edu.zucc.web.model.ViewRun;
import org.apache.poi.xssf.usermodel.*;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 夜跑记录导出为Excel表
 * Created by zxy on 6/11/2016.
 * @author zxyAnkh
 * @since 2016-06-11
 */
public class WriteExcel {
    public String createRunExcel(List<ViewRun> list, String path) {
        //创建一个webbook，对应一个Excel文件
        XSSFWorkbook wb = new XSSFWorkbook();
        //在webbook中添加一个sheet,对应Excel文件中的sheet
        XSSFSheet sheet = wb.createSheet("学生表一");
        //在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
        XSSFRow row = sheet.createRow(0);
        //创建单元格，并设置值表头 设置表头居中
        XSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(XSSFCellStyle.ALIGN_CENTER);

        XSSFCell cell = row.createCell(0);
        cell.setCellValue("学号");
        cell.setCellStyle(style);
        cell = row.createCell(1);
        cell.setCellValue("姓名");
        cell.setCellStyle(style);
        cell = row.createCell(2);
        cell.setCellValue("开始时间");
        cell.setCellStyle(style);
        cell = row.createCell(3);
        cell.setCellValue("结束时间");
        cell.setCellStyle(style);
        cell = row.createCell(4);
        cell.setCellValue("用时");
        cell.setCellStyle(style);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (int i = 0; i < list.size(); i++) {
            row = sheet.createRow(i + 1);
            ViewRun viewRun = list.get(i);
            row.createCell(0).setCellValue(viewRun.getUserno());
            row.createCell(1).setCellValue(viewRun.getUsername());
            row.createCell(2).setCellValue(sdf.format(viewRun.getStarttime()));
            row.createCell(3).setCellValue(sdf.format(viewRun.getEndtime()));
            String time = String.valueOf((viewRun.getTime() - viewRun.getTime() % 60) / 60 + "m" + viewRun.getTime() % 60 + "s");
            row.createCell(4).setCellValue(time);
        }
        sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String fileName = sdf.format(new Date());
        try {
            File dir = new File(path);
            if (!dir.exists()){
                dir.mkdir();
            }
            FileOutputStream fout = new FileOutputStream(path + fileName + ".xls");
            wb.write(fout);
            fout.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileName;
    }
}
