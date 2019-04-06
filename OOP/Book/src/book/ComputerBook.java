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
public class ComputerBook extends Book implements Comparable{
    private String Author;
    private String PublisherName;

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }

    public String getPublisherName() {
        return PublisherName;
    }

    public void setPublisherName(String PublisherName) {
        this.PublisherName = PublisherName;
    }

    public ComputerBook() {
    }

    public ComputerBook(String Author, String PublisherName) {
        this.Author = Author;
        this.PublisherName = PublisherName;
    }
    
    
    @Override
    public void PrintBook() {
        //System.out.println(BookTitle + " " + PublisherName + " " + Author +" " +Price+ " " +Quantity );
        
        //System.out.printf("%5s %5s %5s %5d %5d",BookTitle,PublisherName,Author,Price,Quantity);
        System.out.println("Book title : "+ BookTitle);
        System.out.println("Publisher : "+ PublisherName);
        System.out.println("Author : "+ Author);
        System.out.println("Price : "+ Price);
        System.out.println("Quantity : "+ Quantity);
        System.out.println("______________________");
    }

    @Override
    public double SubTotal() {
        return (Price* Quantity)* 1.1;
    }

    @Override
    public int compareTo(Object t) {
        return BookID-((ComputerBook)t).BookID;
    } 
    
    public static Comparator compareObj = new Comparator(){
        @Override
        public int compare(Object t, Object t1) {
            ComputerBook emp1 = (ComputerBook) t;
            ComputerBook emp2 = (ComputerBook) t1;
            int d =  (int) (emp1.Price - emp2.Price);
            if(d > 0) return -1;
            if(d ==0) return emp1.BookID-emp2.BookID;
            return 1;
        }  
    };
    
}
