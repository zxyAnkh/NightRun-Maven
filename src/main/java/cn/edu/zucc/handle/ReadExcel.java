package cn.edu.zucc.handle;

/**
 * Created by zxy on 6/5/2016.
 */

import cn.edu.zucc.form.BeanuserForm;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zxy on 6/1/2016.
 */
public class ReadExcel {
    public List<BeanuserForm> readExcel(String path) throws IOException {
        if (path == null || "".equals(path))
            return null;
        else {
            String postfix = Util.getPostfix(path);
            if (!"".equals(postfix)) {
                if ("xlsx".equals(postfix) || "xls".equals(postfix))
                    return readXlsx(path);
            }
        }
        return null;
    }

    private List<BeanuserForm> readXlsx(String path) throws IOException {
        System.out.println(path);
        InputStream is = new FileInputStream(path);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
        XSSFDataFormat format = xssfWorkbook.createDataFormat();
        XSSFCellStyle cellStyle = xssfWorkbook.createCellStyle();
        cellStyle.setDataFormat(format.getFormat("@"));
        BeanuserForm BeanuserForm = null;
        List<BeanuserForm> list = new ArrayList<BeanuserForm>();
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
                    BeanuserForm = new BeanuserForm();
                    XSSFCell no = xssfRow.getCell(0);
                    XSSFCell name = xssfRow.getCell(1);
                    no.setCellType(XSSFCell.CELL_TYPE_STRING);
                    no.setCellStyle(cellStyle);
                    BeanuserForm.setNo(getValue(no));
                    BeanuserForm.setName(getValue(name));
                    list.add(BeanuserForm);
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