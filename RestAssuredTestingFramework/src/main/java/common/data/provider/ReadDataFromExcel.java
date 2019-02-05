package common.data.provider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.james.training.RestAssuredTestingFramework.ResourcesPage;

public class ReadDataFromExcel extends ResourcesPage{

    private static ArrayList<String> bookList;
    
    public static void main (String[] args)
    {
        List<String> test = excelBookDetails (2);
        
        for (String string : test) {
            System.out.println(string);
        }
    }

    public static ArrayList<String> excelBookDetails (int colNum)
     {
       
         try {

             File file = new File("C:\\Users\\I350380\\workspace\\RestAssuredTestingFramework\\src\\main\\java\\excel\\data\\resource\\booksData.xlsx");
             FileInputStream excelFile = new FileInputStream(file);
             Workbook workbook = new XSSFWorkbook(excelFile);
             Sheet datatypeSheet = workbook.getSheetAt(0);
            
             Iterator<Row> rowIterator = datatypeSheet.iterator();
             rowIterator.next();
             bookList = new ArrayList<String>();
             while (rowIterator.hasNext()) {
                 String data = String.valueOf((rowIterator.next().getCell(colNum).getStringCellValue().toString()));
                 bookList.add(data);
             }

         }
         catch (FileNotFoundException e) {
             e.printStackTrace();
         }
         catch (IOException e) {
             e.printStackTrace();
         }
        
         return bookList;
     }
    
}
