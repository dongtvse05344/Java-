/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book;

import java.util.Scanner;

/**
 *
 * @author xhunt
 */
public class Program {
    static  Scanner sc=  new Scanner(System.in);
    
    static int choice()
    {
        System.out.println("1. Add Book");
        System.out.println("2. Find Book");
        System.out.println("3. Update Book");
        System.out.println("4. Show Book");
        System.out.print("Your choice : ");
        int c = Integer.parseInt(sc.nextLine());
        return c;
    }
    
    static ComputerBook newBook()
    {
        ComputerBook ans = new ComputerBook();
        System.out.print("Enter Book ID : ");
        ans.BookID =  Integer.parseInt(sc.nextLine());
        System.out.print("Enter Book Title : ");
        ans.BookTitle =  sc.nextLine();
        System.out.print("Enter Book quantity : ");
        ans.Quantity =  Integer.parseInt(sc.nextLine());
        System.out.print("Enter Book Price : ");
        ans.Price =  Double.parseDouble(sc.nextLine());
        System.out.print("Enter Book Author : ");
        ans.setAuthor(sc.nextLine());
        System.out.print("Enter Book Publisher : ");
        ans.setPublisherName(sc.nextLine());
        return ans;
    }
    
    public static void main(String[] args) {
        BookManager boss = new BookManager();
        
        int c;
        do
        {
             c = choice();
            switch(c)
            {
                case 1 :
                    ComputerBook book = newBook();
                    boss.addBook(book);
                    break;
                case 2 :
                    System.out.print("Enter ID : ");
                    int ID = Integer.parseInt(sc.nextLine());
                    boss.findBookByID(ID).PrintBook();
                    break;
                case 3 :
                    ComputerBook book1 = newBook();
                    boss.updateBook(book1);
                    break;
                case 4 : boss.showBook(); break;
                default :c =-1;
            }
        } while (c != -1);
        
        
    }
}
