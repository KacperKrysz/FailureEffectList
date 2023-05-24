import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {

    public static void main(String[] args) {

        FailureAndCauseReader failureAndCauseReader = new FailureAndCauseReader();
        failureAndCauseReader.FCReader();
        //System.out.println(arrayList.toString());

    }
}


