package utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtils {

    public static List<String[]> readSheet(String filePath, String sheetName) {
        List<String[]> rows = new ArrayList<>();
        try (InputStream is = new FileInputStream(filePath);
             XSSFWorkbook wb = new XSSFWorkbook(is)) {
            Sheet sheet = wb.getSheet(sheetName);
            DataFormatter formatter = new DataFormatter();
            for (Row r : sheet) {
                int last = r.getLastCellNum();
                String[] cells = new String[last];
                for (int i = 0; i < last; i++) {
                    cells[i] = formatter.formatCellValue(r.getCell(i));
                }
                rows.add(cells);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to read Excel file: " + filePath, e);
        }
        return rows;
    }
}
