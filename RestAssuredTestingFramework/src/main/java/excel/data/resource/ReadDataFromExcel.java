package excel.data.resource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.james.training.RestAssuredTestingFramework.ResourcesPage;

public class ReadDataFromExcel extends ResourcesPage{

    private static ArrayList<String> itemList;
    
    public static void main (String[] args) throws IOException, EncryptedDocumentException, InvalidFormatException
    {
        getBookDetailFromExcel(0,2);
        print();
 
    }

    public static List<String> getBookDetailFromExcel (int sheetNum, int colNum) throws FileNotFoundException, IOException, InvalidFormatException
    {
        itemList = new ArrayList<String>();
        String filename = "C:\\Users\\I350380\\workspace\\RestAssuredTestingFramework\\src\\main\\java\\excel\\data\\resource\\booksData.xlsx";
        FileInputStream fis=new FileInputStream(filename);
        Workbook wb = WorkbookFactory.create(fis);
        DataFormatter objDefaultFormat = new DataFormatter();
        FormulaEvaluator objFormulaEvaluator = new XSSFFormulaEvaluator((XSSFWorkbook) wb);

        Sheet sheet= wb.getSheetAt(sheetNum);
        Iterator<Row> objIterator = sheet.rowIterator();

        while(objIterator.hasNext()){

            Row row = objIterator.next();
            int r = row.getRowNum();
            //0=column title - we skip it
            if(!(row.getRowNum()==0)){
                
                Cell cellValue = row.getCell(colNum);
             // This will evaluate the cell, And any type of cell will return string value
                objFormulaEvaluator.evaluate(cellValue);
                
                String cellValueStr = objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator);
                // add item to list
                itemList.add(cellValueStr);
                
            }
        }
        return itemList;
    }
    
    public static void print(){
        for (int i = 0; i < itemList.size(); i++) {
            System.out.println(itemList.get(i));
        }
    }
    
}
