package page_object_model.utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelUtil {
    private static final String FILE_PATH = "src/test/java/page_object_model/resources/TestData.xlsx";

    public static List<Object[]> getLoginData() throws IOException {
        List<Object[]> data = new ArrayList<>();
        FileInputStream file = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheet("LoginData");

        Iterator<Row> rowIterator = sheet.iterator();
        rowIterator.next();

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            String username = row.getCell(0).getStringCellValue();
            String password = row.getCell(1).getStringCellValue();
            String expectedResult = row.getCell(2).getStringCellValue();
            data.add(new Object[]{username, password, expectedResult});
        }
        workbook.close();
        return data;
    }
}

