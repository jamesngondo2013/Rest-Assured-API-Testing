package com.james.training.RestAssuredTestingFramework;

import java.util.ArrayList;
import java.util.List;

public class BookDetails {

    private String book_id;
    private String isbn;
    private String aisle;
    private String book_name;
    private String author;
  
    private static ArrayList<String> bookidList = new ArrayList<String>();
    
    public BookDetails (String book_id, String isbn, String aisle, String book_name, String author)
    {
        setBook_id(book_id);
        setIsbn(isbn);
        setAisle(aisle);
        setBook_name(book_name);
        setAuthor(author);
    }
    
    public BookDetails (String isbn, String aisle, String book_name,String author)
    { 
        setIsbn(isbn);
        setAisle(aisle);
        setBook_name(book_name);
        setAuthor(author);    
    }
    
    public BookDetails (String isbn, String aisle)
    {
        setIsbn(isbn);
        setAisle(aisle);
        
    }
    public String getBook_id ()
    {
        return book_id;
    }
    public void setBook_id (String book_id)
    {
        this.book_id = book_id;
    }
    public String getIsbn ()
    {
        return isbn;
    }
    public void setIsbn (String isbn)
    {
        this.isbn = isbn;
    }
    public String getAisle ()
    {
        return aisle;
    }
    public void setAisle (String aisle)
    {
        this.aisle = aisle;
    }
    public String getBook_name ()
    {
        return book_name;
    }
    public void setBook_name (String book_name)
    {
        this.book_name = book_name;
    }
    public String getAuthor ()
    {
        return author;
    }
    public void setAuthor (String author)
    {
        this.author = author;
    }

    public static List<String> getAllBookIDs ()
    {
        return bookidList;
    }
    public static void setBookid (String id)
    {
        bookidList.add(id);
       
    }
    
}
