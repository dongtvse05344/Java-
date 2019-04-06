/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeetest;

import employeedata.EmployeeData;
import java.util.*;

/**
 *
 * @author xhunt
 */
public class EmployeeTest {
    public static void main(String[] args) {
        EmployeeData empData = new EmployeeData();
        int choice;
        Scanner sc = new Scanner(System.in);
        System.out.println("\n!!! Welcome to My company!!!\n"+"Select the operation you want to perform:");
        do{
            System.out.println("****************");
            System.out.println("1. Add new employee");
            System.out.println("2. Display the employee details");
            System.out.println("3. Delete employee");
            System.out.println("4. Publish the entire list");
            System.out.println("5. Exit");
            System.out.println("********************");
            System.out.println("Choice : ");
            choice = Integer.parseInt(sc.nextLine());
            
            switch(choice)
            {
                case 1 : empData.addEmployee(); break;
                case 2 : empData.findEmployee(); break;
                case 3 : empData.removeEmployee(); break;
                case 4 : empData.printEmployeeList(); break;
                default : System.out.println("Not a valid choice !!!");
            }
        } while(choice !=5);
    }
}
