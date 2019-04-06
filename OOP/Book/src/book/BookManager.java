/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book;

import java.util.*;

/**
 *
 * @author xhunt
 */
public class BookManager implements IBookCommand{
    ArrayList<Book> listBook = new ArrayList<Book>();
    int noBook =0;
    @Override
    public void addBook(Book book) {
        listBook.add(book);
    }

    @Override
    public Book findBookByID(int ID) {
        for (Object obj : listBook){
            Book book =(Book)obj;
            if(book.BookID == ID){
                return book;
            }
        }
        return null;
    }

    @Override
    public Book updateBook(Book book) {
        for (Object obj : listBook){
            Book book1 =(Book)obj;
            if(book1.BookID == book.BookID){
                book1 = book;
            }
        }
        return book;
    }

    @Override
    public void showBook() {
        //System.out.println("BookTitle | PublisherName  |  Author  |   Price   | Quantity " );
        for (Object obj : listBook){
            Book book =(Book)obj;
            book.PrintBook();
        }
    }
   public void SortBook(){
        Collections.sort(listBook,ComputerBook.compareObj);
    }
    
}
