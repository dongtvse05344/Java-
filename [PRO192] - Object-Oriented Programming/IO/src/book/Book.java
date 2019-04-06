/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book;

import java.io.Serializable;

/**
 *
 * @author xhunt
 */
public class Book implements Serializable{
    private int    price ;
    private String title;

    public Book(int price, String title) {
        this.price = price;
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public void print()
    {
        System.out.println("Title : "+ title +" Price : " +price);
    }
    
}
