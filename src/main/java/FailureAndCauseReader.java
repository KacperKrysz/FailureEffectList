import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class FailureAndCauseReader {

    public void FCReader() {

        String filePath = "C:\\Users\\kacpe\\OneDrive\\Pulpit\\sad.xlsx";;

        ArrayList<FailureAndCauseOb> arrayList = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0); // Pobierz pierwszy arkusz
            int columnIIndex = 8; // Indeks kolumny G (liczone od 0)
            int columnJIndex = 9;
            //int arraySize = sheet.getLastRowNum();
            //FailureEffectOb[] arrayFailureEffectOb = new FailureEffectOb[arraySize];
            String cellValue = "";

            ArrayList<String> causesList = new ArrayList<>();

            for (Row row : sheet) {
                int rowNumber = row.getRowNum() - 7;
                Cell cellI = row.getCell(columnIIndex);
                Cell cellJ = row.getCell(columnJIndex);




                    if (cellI != null && cellI.getCellType() == CellType.STRING && cellI.getRowIndex() >= 8) {
                        cellValue = cellI.getStringCellValue();
                        //for(int i = 0; i < smallArr.length; i++) {

                        if (cellJ != null && cellJ.getCellType() == CellType.STRING && cellJ.getRowIndex() >= 8 && !cellJ.getStringCellValue().trim().isEmpty()) {
                            String causeCellValue = cellJ.getStringCellValue();
                            causesList.add(causeCellValue);
                        }
                        //     arrayList.add(failureAndCauseOb);
                        //}

                    } else {

                        if (cellJ != null && cellJ.getCellType() == CellType.STRING && cellJ.getRowIndex() >= 8) {
                            String causeCellValue = cellJ.getStringCellValue();
                            causesList.add(causeCellValue);
                        }
                        //   System.out.println(failureAndCauseOb);


                    }

                FailureAndCauseOb failureAndCauseOb = new FailureAndCauseOb(rowNumber,cellValue,causesList);

                arrayList.add(failureAndCauseOb);
                //causesList.clear();
                System.out.println(failureAndCauseOb);
                System.out.println("\nRow: " +rowNumber + "\n");

                }






        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
