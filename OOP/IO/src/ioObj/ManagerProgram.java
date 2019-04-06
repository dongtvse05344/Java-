/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ioObj;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author xhunt
 */
public class ManagerProgram {
    public static void main(String[] args) throws IOException {
        String filename = "employees.txt";
        Scanner sc = new Scanner(System.in);
        Menu menu= new Menu();
        menu.add("1-Add new employee");
        menu.add("2-Remove employee");
        menu.add("3-Print the list");
        menu.add("4-Save to files");
        menu.add("Quit");
        int userChoice;
        boolean changed = false;
        EmpList list = new EmpList();
        list.AddFromFile(filename);
        do{
            System.out.println("EMPLOYEE MANAGER");
            userChoice = menu.getUserchoice();
            switch(userChoice)
            {
                case 1: list.addNewEmp(); changed = true; break;
                case 2: list.removeEmp();changed = true; break;
                case 3: list.print();changed = true; break;
                case 4: list.saveToFile(filename);changed = false; break;
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
