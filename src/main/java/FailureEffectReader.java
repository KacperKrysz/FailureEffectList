import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class FailureEffectReader {

    public void effectReader() {

        String filePath = "path to xls";;

        ArrayList<FailureEffectOb> arrayList = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0); // Pobierz pierwszy arkusz
            int columnGIndex = 6; // Indeks kolumny G (liczone od 0)
            int arraySize = sheet.getLastRowNum();

            //FailureEffectOb[] arrayFailureEffectOb = new FailureEffectOb[arraySize];

            for (Row row : sheet) {
                Cell cell = row.getCell(columnGIndex);
                if (cell != null && cell.getCellType() == CellType.STRING && cell.getRowIndex() >= 8) {
                    String cellValue = cell.getStringCellValue();
                    String[] smallArr = cellValue.split("\n\r\n\r|\n\n\n");
                    int rowNumber = row.getRowNum() - 7; // Numer wiersza
                    for(int i = 0; i < smallArr.length; i++) {

                        FailureEffectOb failureEffectOb = new FailureEffectOb(rowNumber,smallArr[i]);
                        System.out.println(failureEffectOb);
                        //System.out.println("ID = " + rowNumber + ", Value = " + cellValue);
                        arrayList.add(failureEffectOb);
                    }

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
