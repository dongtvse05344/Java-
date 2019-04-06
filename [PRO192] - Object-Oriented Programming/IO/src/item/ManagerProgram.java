/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package item;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author xhunt
 */
public class ManagerProgram {
    public static void main(String[] args) throws IOException {
        String filename ="items.txt";
        Scanner sc = new Scanner(System.in);
        Menu menu= new Menu();
        menu.add("1-Add new item");
        menu.add("2-Remove new book");
        menu.add("3-Save to files");
        menu.add("Quit");
        int userChoice;
        boolean changed = false;
        ItemList list = new ItemList();
        list.LoadStoredCode(filename);
        do{
            System.out.println("EMPLOYEE MANAGER");
            userChoice = menu.getUserchoice();
            switch(userChoice)
            {
                case 1: list.AddNewItem();changed = true; break;
                default : 
                    if(changed)
                    {
                        System.out.println("Save changes Y/N");
                        String response = sc.nextLine().toUpperCase();
                        if(response.startsWith("Y"))
                        {
                            list.appendToFile(filename);
                        }
                    }
                    userChoice = -1;
                
            }
        }            while (userChoice !=-1);
    }
}
