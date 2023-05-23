import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {

    public static void main(String[] args) {
        String filePath = "C:\\Users\\Kacper\\Desktop\\\\sad.xlsx";;

        ArrayList<FailureEffectOb> arrayList = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0); // Pobierz pierwszy arkusz
            int columnGIndex = 6; // Indeks kolumny G (liczone od 0)
            int arraySize = sheet.getLastRowNum();

            FailureEffectOb[] arrayFailureEffectOb = new FailureEffectOb[arraySize];

            for (Row row : sheet) {
                Cell cell = row.getCell(columnGIndex);
                if (cell != null && cell.getCellType() == CellType.STRING && cell.getRowIndex() >= 8) {
                    String cellValue = cell.getStringCellValue();
                    int rowNumber = row.getRowNum() - 7; // Numer wiersza
                    FailureEffectOb failureEffectOb = new FailureEffectOb(rowNumber,cellValue);
                    System.out.println("ID = " + rowNumber + ", Value = " + cellValue);
                    arrayList.add(failureEffectOb);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(arrayList.toString());

    }
}


