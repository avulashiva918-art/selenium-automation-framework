package com.shiva.tests;

import org.testng.annotations.DataProvider;
import com.shiva.utils.ExcelReader;

public class LoginDataProvider {

    @DataProvider(name = "loginData")
    public Object[][] getData() {

        int rows = ExcelReader.getRowCount();
        int cols = ExcelReader.getColumnCount();

        Object[][] data = new Object[rows - 1][cols];

        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                data[i - 1][j] = ExcelReader.getCellData(i, j);
            }
        }

        return data;
    }
}