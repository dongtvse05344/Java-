/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package person;

import java.util.Scanner;

/**
 *
 * @author xhunt
 */
public class Program {
    int choice()
    {
        System.out.println("PERSON MANAGER");
        System.out.println("1. Add new person");
        System.out.println("2.Remove a person");
        System.out.println("3.Update a person");
        System.out.println("4.List");
        System.out.println("Order - Quit");
        Scanner sc = new Scanner(System.in);
        int c = Integer.parseInt(sc.nextLine());
        return c;
    }
    public static void main(String[] args) {
        Program p = new Program();
        PersonList list = new PersonList(20);
        int c;
        do
        {
            c = p.choice();
            switch(c)
            {
                case 1 :  list.add(); break;
                case 2 :  list.remove(); break;
                case 3 :  list.update(); break;
                case 4 :  list.print(); break;
                default : c = -1;
            }
        } while (c != -1);
    }
}
