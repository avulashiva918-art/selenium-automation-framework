package com.shiva.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

    static XSSFWorkbook workbook;
    static XSSFSheet sheet;

    static {
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/LoginData.xlsx");
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheetAt(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getCellData(int row, int column) {
        return sheet.getRow(row).getCell(column).toString();
    }
    public static int getRowCount() {
        return sheet.getPhysicalNumberOfRows();
    }

    public static int getColumnCount() {
        return sheet.getRow(0).getPhysicalNumberOfCells();
    }
}