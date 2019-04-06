/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import doctorhash.DoctorHash;
import java.util.Scanner;

/**
 *
 * @author xhunt
 */
public class Test {
    public static void main(String[] args) {
        DoctorHash doctorHash = new DoctorHash();
        int choice;
        Scanner sc = new Scanner(System.in);
        do
        {
            System.out.println("\nWelcome to lifeline hospital!!!\n");
            System.out.println("1.Register doctor");
            System.out.println("2. Display doctor details");
            System.out.println("3. publish the entire list");
            System.out.println("4. Exit");
            choice = Integer.parseInt(sc.nextLine());
            switch(choice)
            {
                case 1 : doctorHash.add();
                break;
                case 2 : doctorHash.display();
                break;
                case 3 : doctorHash.publish();
                break;
                case 4 :break;
            }
        } while (choice !=4);
    }
}
