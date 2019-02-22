package db.data.source;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.james.training.RestAssuredTestingFramework.BookDetails;

 public class DBConnectionDAO {
	
	private static DBConnectionDAO DAOINSTANCE;
	 
	private DBConnectionDAO(){
	
	}
	
    public static synchronized DBConnectionDAO getINSTANCE() {
		
		if (DAOINSTANCE==null) {
			DAOINSTANCE = new DBConnectionDAO();
		}
		return DAOINSTANCE;
	}
	
	static List<BookDetails> bookDetails;
	
	public static void main(String[] args) {
		DBConnectionDAO dao = DBConnectionDAO.getINSTANCE();
		
		List<BookDetails> book = dao.getData();
		for (BookDetails b : book) {
			String aile = b.getAisle();
			String isbn = b.getIsbn();
			System.out.println(aile +" " + isbn);
		}
	}
	
	
    
    public List<BookDetails> getData(){
    	
    	bookDetails = new ArrayList<BookDetails>();
    	
    	DatabaseConnectionManager con = DatabaseConnectionManager.getConnectionManagerInstance();
    	con.connect();
        
    	Statement stmt = null;
    	ResultSet rs = null;

    	try {
    	        stmt = con.getConn().createStatement();
                rs = stmt.executeQuery("select * FROM automation.bookdata");
                while (rs.next()) {
                    String book_id = rs.getString("book_id");
                    String isbn = rs.getString("isbn");
                    String aisle = rs.getString("aisle");
                    String book_name = rs.getString("book_name");
                    String author = rs.getString("author");
                    
                    bookDetails.add(new BookDetails(book_id,isbn,aisle,book_name,author));
                   // System.out.println("book_id:" + book_id);
                   // System.out.println("isbn:" + isbn);                 
                }           
         
        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("cannot connect to database...");
        }
        return bookDetails;
    }
}
