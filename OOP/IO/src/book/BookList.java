/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book;

import ioObj.Employee;
import java.io.*;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;

/**
 *
 * @author xhunt
 */
public class BookList extends Vector<Book>{
    Scanner sc = new Scanner(System.in);
    
    public void AddFromFile(String fName) throws FileNotFoundException, IOException{
        try{
            File f = new File(fName);
            if(!f.exists()) return;
            FileInputStream fi = new FileInputStream(f);
            ObjectInputStream oi = new ObjectInputStream(fi);
            String details;
            Book b;
            while((b = (Book)(oi.readObject()))!= null)
            {
                this.add(b);
            }
            oi.close(); fi.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public void saveToFile(String fName) throws IOException
    {
        if(this.size()==0)
        {
            System.out.println("Empty list");
            return;
        }
        try{
            FileOutputStream f = new FileOutputStream(fName);
            ObjectOutputStream oo = new ObjectOutputStream(f);
            for(Book b:this)
            {
                oo.writeObject(b);
            }
            oo.close(); f.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public void addNewBook()
    {
        String title;
        int price;
        System.out.println("Enter New Book Details");
        System.out.print("   title:");
        title= sc.nextLine();
        System.out.print("   price:");
        price = Integer.parseInt(sc.nextLine());
        this.add(new Book(price, title));
        System.out.println("New Book has been added");
    }
    
    public void print()
    {
        if(this.size()==0)
        {
            System.out.println("Empty list.");
            return ;
        }
        System.out.println("\nBOOK LIST");
        System.out.println("---------------------------");
        for(Book x:this)x.print();
    }
    
}
