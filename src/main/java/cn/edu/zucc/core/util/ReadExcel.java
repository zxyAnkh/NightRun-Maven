package cn.edu.zucc.core.util;

/**
 * 读取Excel文件
 * Created by zxy on 6/5/2016.
 * @author zxyAnkh
 * @since 2016-06-05
 */

import cn.edu.zucc.web.form.UserForm;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ReadExcel {

    public String getPostfix(String path){
        if(path == null || "".equals(path.trim()))
            return "";
        if(path.contains("."))
            return path.substring(path.lastIndexOf(".") + 1);
        return "";
    }

    public List<UserForm> readExcel(String path) throws IOException {
        if (path == null || "".equals(path))
            return null;
        else {
            String postfix = getPostfix(path);
            if (!"".equals(postfix)) {
                if ("xlsx".equals(postfix) || "xls".equals(postfix))
                    return readXlsx(path);
            }
        }
        return null;
    }

    private List<UserForm> readXlsx(String path) throws IOException {
        System.out.println(path);
        InputStream is = new FileInputStream(path);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
        XSSFDataFormat format = xssfWorkbook.createDataFormat();
        XSSFCellStyle cellStyle = xssfWorkbook.createCellStyle();
        cellStyle.setDataFormat(format.getFormat("@"));
        List<UserForm> list = new ArrayList<UserForm>();
        // Read the Sheet
        for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {
            XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
            if (xssfSheet == null) {
                continue;
            }
            // Read the Row
            for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
                XSSFRow xssfRow = xssfSheet.getRow(rowNum);
                if (xssfRow != null) {
                    UserForm userForm = new UserForm();
                    XSSFCell no = xssfRow.getCell(0);
                    XSSFCell name = xssfRow.getCell(1);
                    no.setCellType(XSSFCell.CELL_TYPE_STRING);
                    no.setCellStyle(cellStyle);
                    userForm.setUserno(getValue(no));
                    userForm.setUsername(getValue(name));
                    list.add(userForm);
                }
            }
        }
        return list;
    }

    private String getValue(XSSFCell xssfRow) {
        if (xssfRow.getCellType() == xssfRow.CELL_TYPE_BOOLEAN) {
            return String.valueOf(xssfRow.getBooleanCellValue());
        } else if (xssfRow.getCellType() == xssfRow.CELL_TYPE_NUMERIC) {
            return String.valueOf(xssfRow.getNumericCellValue());
        } else {
            return String.valueOf(xssfRow.getStringCellValue());
        }
    }
}