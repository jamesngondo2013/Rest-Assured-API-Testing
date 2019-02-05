package db.data.source;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.james.training.RestAssuredTestingFramework.BookDetails;

public class DBConnection {

static List<BookDetails> bookDetails;
    
    public List<BookDetails> getData(){

        bookDetails = new ArrayList<BookDetails>();
        Connection con = null;
        try {
            con = (Connection)DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/automation", "root", "chingotah1980");
            
            if (con!=null) {
                System.out.println("successfully connected to database...");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(
                    "select * FROM automation.bookdata");
                while (rs.next()) {
                    String book_id = rs.getString("book_id");
                    String isbn = rs.getString("isbn");
                    String aisle = rs.getString("aisle");
                    String book_name = rs.getString("book_name");
                    String author = rs.getString("author");
                    
                    bookDetails.add(new BookDetails(book_id,isbn,aisle,book_name,author));
                   // System.out.println("Username:" + username);
                   // System.out.println("Password:" + password);
                   
                }
               
            }
         
        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("cannot connect to database...");
        }
        return bookDetails;
    }
}
