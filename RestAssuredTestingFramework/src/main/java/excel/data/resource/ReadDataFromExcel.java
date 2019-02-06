package excel.data.resource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

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
    
    ArrayList<String> itemList;
    FileInputStream input;
    
    public ReadDataFromExcel () throws IOException
    {
        getData();
    }

    public static void main (String[] args) throws IOException, EncryptedDocumentException, InvalidFormatException
    {
    }

    public List<String> getBookDetailFromExcel (int sheetNum, int colNum) throws FileNotFoundException, IOException, InvalidFormatException
    {
        itemList = new ArrayList<String>();
        input=new FileInputStream(prop.getProperty("EXCEL_SOURCE_PATH"));
        Workbook wb = WorkbookFactory.create(input);
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
    
    public void print(){
       
    }
    
}
