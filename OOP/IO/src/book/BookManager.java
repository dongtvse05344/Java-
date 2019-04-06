/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author xhunt
 */
public class BookManager {
    public static void main(String[] args) throws IOException {
        String filename = "books.txt";
        Scanner sc = new Scanner(System.in);
        Menu menu= new Menu();
        menu.add("1-Views book");
        menu.add("2-Add new book");
        menu.add("3-Save to files");
        menu.add("Quit");
        int userChoice;
        boolean changed = false;
        BookList list = new BookList();
        list.AddFromFile(filename);
        do{
            System.out.println("EMPLOYEE MANAGER");
            userChoice = menu.getUserchoice();
            switch(userChoice)
            {
                case 1: list.print();changed = true; break;
                case 2: list.addNewBook();changed = true; break;
                case 3: list.saveToFile(filename);changed = false; break;
                default : 
                    if(changed)
                    {
                        System.out.println("Save changes Y/N");
                        String response = sc.nextLine().toUpperCase();
                        if(response.startsWith("Y"))
                        {
                            list.saveToFile(filename);
                        }
                    }
                    userChoice = -1;
                
            }
        }            while (userChoice !=-1);
    }
}
