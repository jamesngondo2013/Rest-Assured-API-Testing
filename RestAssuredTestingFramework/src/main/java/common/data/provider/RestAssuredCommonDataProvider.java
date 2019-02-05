/**
 * 
 */
package common.data.provider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.james.training.RestAssuredTestingFramework.BookDetails;
import com.james.training.RestAssuredTestingFramework.HTTPPayloadPage;

/**
 * @author james.ngondo
 *
 */
public class RestAssuredCommonDataProvider {
    
    private ReadDataFromExcel readExcelData;
    private static List<BookDetails> bookDetails;
    private static ArrayList<String> isbn;
    private static ArrayList<String> aisle;
    private static ArrayList<String> bookName;
    private static ArrayList<String> author;
    private static List<String> bookid;

    public static void main (String[] args)
    {
       // getBookDataDB ();
    }

    @DataProvider(name="getDBDataAllFields",parallel=false)
    public Object[][] getDBDataAllFields ()
    {
        isbn = new ArrayList<String>();;
        aisle = new ArrayList<String>();
        bookName = new ArrayList<String>();;
        author = new ArrayList<String>();
        
        Object[][] data;
        
        bookDetails = new ArrayList<BookDetails>();
        Connection con = null;
        try {
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/automation", "root", "chingotah1980");

            if (con != null) {
                System.out.println("successfully connected to database...");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select * FROM automation.bookdata");
                while (rs.next()) {
                   
                    String isbn = rs.getString("isbn");
                    String aisle = rs.getString("aisle");
                    String book_name = rs.getString("book_name");
                    String author = rs.getString("author");
                    //add books to na list
                    bookDetails.add(new BookDetails(isbn, aisle,book_name,author));     
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
    
    @DataProvider(name="getBookDataDB",parallel=false)
    public Object[][] getBookDataDB ()
    {
        isbn = new ArrayList<String>();;
        aisle = new ArrayList<String>();
      
        Object[][] data;
        
        bookDetails = new ArrayList<BookDetails>();
        Connection con = null;
        try {
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/automation", "root", "chingotah1980");

            if (con != null) {
                System.out.println("successfully connected to database...");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select * FROM automation.bookdata");
                while (rs.next()) {
                    //get isbn from db
                    String isbn = rs.getString("isbn");
                    //get aisle from db
                    String aisle = rs.getString("aisle");
                    //add each book to a list
                    bookDetails.add(new BookDetails(isbn, aisle));
               
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
    
    @DataProvider(name="getBookExcelData",parallel=true)
    public Object[][] getBookExcelData ()
    {
        readExcelData = new ReadDataFromExcel();
        ArrayList<String> isbn = readExcelData.excelBookDetails(1);
        ArrayList<String> aisle = readExcelData.excelBookDetails(2);
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
