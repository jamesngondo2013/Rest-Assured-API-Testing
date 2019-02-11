/**
 * 
 */
package common.data.provider;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;

import com.james.training.RestAssuredTestingFramework.BookDetails;
import com.james.training.RestAssuredTestingFramework.HTTPPayloadPage;
import com.james.training.RestAssuredTestingFramework.ResourcesPage;

import excel.data.resource.ReadDataFromExcel;

/**
 * @author james.ngondo
 *
 */
public class RestAssuredCommonDataProvider extends ResourcesPage{
    
    private static List<BookDetails> bookDetails;
    private static List<String> bookid;
    private ReadDataFromExcel excelData;
    private  Connection con = null;
    private String url;
    private String pass;
    private String root;
    

    public RestAssuredCommonDataProvider () throws FileNotFoundException, IOException
    {
       getData();
    }

    public static void main (String[] args) throws FileNotFoundException, InvalidFormatException, IOException
    {
       // getBookExcelData ();
    }

    //====================================================
  //This is for MYSQL dataProider - returns ALL items - BOOK-NAME,ISBN, AISLE, AUTHOR
    @DataProvider(name="getDBDataAllFields",parallel=true)
    public Object[][] getDBDataAllFields () throws ClassNotFoundException
    {
        List<BookDetails> bookDetails;
        
        ArrayList<String> isbn = new ArrayList<String>();;
        ArrayList<String> aisle = new ArrayList<String>();
        ArrayList<String> bookName = new ArrayList<String>();;
        ArrayList<String> author = new ArrayList<String>();
        
        Object[][] data;
        
        bookDetails = new ArrayList<BookDetails>();
        
        url = prop.getProperty("SQL_URL");
        pass= prop.getProperty("SQL_PASS");
        root = prop.getProperty("SQL_ROOT");
 
        try {
            
            con = (Connection) DriverManager.getConnection(url, root, pass);
            if (con != null) {
                System.out.println("successfully connected to database...");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select * FROM automation.bookdata");
                while (rs.next()) {
                   
                    String db_isbn = rs.getString("isbn");
                    String db_aisle = rs.getString("aisle");
                    String db_book_name = rs.getString("book_name");
                    String db_author = rs.getString("author");
                    //add books to na list
                    bookDetails.add(new BookDetails(db_isbn, db_aisle,db_book_name,db_author));     
                }

            }

        }
        catch (SQLException e) {
           
            e.printStackTrace();
            System.out.println("cannot connect to database...");
        }
        //retrieve book details for each book in a list and add them to individual lists
        for (BookDetails val : bookDetails) {
            
            isbn.add(val.getIsbn());
            aisle.add(val.getAisle());
            bookName.add(val.getBook_name());
            author.add(val.getAuthor());
        }
        
        int size = bookDetails.size();
 
        data = new Object[size][4];
        
        for (int i = 0; i < isbn.size(); i++) {
            data[i][0] = isbn.get(i).toString();
              
            for (int j = 0; j < aisle.size(); j++) {
                data[j][1] = aisle.get(j).toString();
                data[j][2] = bookName.get(j).toString();
                data[j][3] = author.get(j).toString();
          }
        }
       
    
      for (int i = 0; i < data.length; i++) {
        // System.out.print(data[i][0].toString());
         System.out.println(" " + data[i][3].toString());
          
      }
      
        return data;
    }
    
    //========================================================
  //This is for MYSQL dataProider - returns ISBN, AISLE
    @DataProvider(name="getBookDataDB",parallel=true)
    public Object[][] getBookDataDB ()
    {
        ArrayList<String> isbn = new ArrayList<String>();;
        ArrayList<String> aisle = new ArrayList<String>();
      
        Object[][] data;
        
        bookDetails = new ArrayList<BookDetails>();
        
        url = prop.getProperty("SQL_URL");
        pass= prop.getProperty("SQL_PASS");
        root = prop.getProperty("SQL_ROOT");

        try {
            con = (Connection) DriverManager.getConnection(url, root, pass);

            if (con != null) {
                System.out.println("successfully connected to database...");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select * FROM automation.bookdata");
                while (rs.next()) {
                    //get isbn from db
                    String db_isbn = rs.getString("isbn");
                    //get aisle from db
                    String db_aisle = rs.getString("aisle");
                    //add each book to a list
                    bookDetails.add(new BookDetails(db_isbn, db_aisle));
               
                }

            }

        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("cannot connect to database...");
        }
        //retrieve book details for each book in a list and add them to individual lists
        for (BookDetails val : bookDetails) {
              
            isbn.add(val.getIsbn());
            aisle.add(val.getAisle());
        }
 
        int size= bookDetails.size();
        
        data = new Object[size][2];
        
        for (int i = 0; i < isbn.size(); i++) {
            data[i][0] = isbn.get(i).toString();
              
            for (int j = 0; j < aisle.size(); j++) {
                data[j][1] = aisle.get(j).toString();
          }
        }
       
    
      for (int i = 0; i < data.length; i++) {
         System.out.print(data[i][0].toString());
         System.out.println(" " + data[i][1].toString());
          
      }
      
        return data;
    }
    
    //========================================================
    //This is for excel data - returns ISBN, AISLE
    @DataProvider(name="getBookExcelData",parallel=false)
    public Object[][] getBookExcelData () throws FileNotFoundException, InvalidFormatException, IOException
    {
        excelData = new ReadDataFromExcel();
        
        List<String> isbn = excelData.getBookDetailFromExcel(0, 1);
        List<String> aisle = excelData.getBookDetailFromExcel(0, 2);
        
        int size = aisle.size();

        Object[][] data = new Object[size][2];

        for (int i = 0; i < isbn.size(); i++) {
            data[i][0] = isbn.get(i).toString();

            for (int j = 0; j < aisle.size(); j++) {
                data[j][1] = aisle.get(j).toString();
                
            }
        }

        // [size]= row - stands for how many times different data types the test should
        // e.g 2 times
        // run
        // [2]= col- stands for how many values per each test eg (username,
        // password)

        // ===Data type 1
        /* data[0][0] = "nonresticteduser@gmail.com";
         data[0][1] = "123456";
*/
        // ===Data type 2
         /*data[1][0] = "resticteduser@gmail.com";
         data[1][1] = "45678";
         return new Object[][]{{"xvbb,"1234"},{"qwwee","5667"},{"gsxwee","58967}}
         
*/
        return data;

    }
    
    //======================================================
    //This is for excel data - returns ISBN, AISLE
    @DataProvider(name="getAllBookFieldsExcelData",parallel=false)
    public Object[][] getAllBookFieldsExcelData () throws FileNotFoundException, InvalidFormatException, IOException
    {
        excelData = new ReadDataFromExcel();
        
        List<String> book_name = excelData.getBookDetailFromExcel(0, 0);
        List<String> isbn = excelData.getBookDetailFromExcel(0, 1);
        List<String> aisle = excelData.getBookDetailFromExcel(0, 2);
        List<String> author = excelData.getBookDetailFromExcel(0, 3);
        
        int size = aisle.size();

        Object[][] data = new Object[size][4];

        for (int i = 0; i < isbn.size(); i++) {
            data[i][0] = isbn.get(i).toString();

            for (int j = 0; j < aisle.size(); j++) {
                data[j][1] = aisle.get(j).toString();
                data[j][2] = book_name.get(j).toString();
                data[j][3] = author.get(j).toString();
            }
        }

        return data;

    }
    
   //================================================================ 
  //This is A COMMON delete data provider - returns ALL book IDs
    @DataProvider(name="deleteBookID",parallel=true)
    public Object[][] deleteBookID(){
      // id = new ArrayList<String>();
        bookid = BookDetails.getAllBookIDs();
       
       int size = bookid.size();
       
       Object[][] data = new Object[size][1];
       
       for (int i = 0; i < bookid.size(); i++) {
           data[i][0] = bookid.get(i).toString();
           
           System.out.println("BookID From DataProvider: "+ data[i][0]);
       }
        return data;
        
    }
}