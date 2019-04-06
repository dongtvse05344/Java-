/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeedata;

import employeedetail.EmployeeDetail;
import java.util.*;

/**
 *
 * @author xhunt
 */
public class EmployeeData {
    ArrayList empList = new ArrayList();
    
    public void addEmployee(){
        String name,adress,code;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the employee code :");
        code = sc.nextLine();
        System.out.print("Enter the name : ");
        name = sc.nextLine();
        System.out.print("Enter the address : ");
        adress = sc.nextLine();
        EmployeeDetail emp = new EmployeeDetail(code.toUpperCase(), name, adress);
        empList.add(emp);
    }
    public void removeEmployee(){
        String searchcode;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter employee code : ");
        searchcode = sc.nextLine();
        for(Object obj : empList)
        {
            EmployeeDetail emp = (EmployeeDetail)obj;
            if(emp.empCode.equals(searchcode.toUpperCase())){
                empList.remove(emp);
                System.out.println("Employee code :"+ searchcode + "removed.");
                return;
            }
            
        }
        System.out.println("Employee not found!!!");
    }
    
    public void findEmployee()
    {
        String searchcode;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter employee code : ");
        searchcode = sc.nextLine();
        for(Object obj : empList)
        {
            EmployeeDetail emp = (EmployeeDetail)obj;
            if(emp.empCode.equals(searchcode.toUpperCase())){
                System.out.println("Employee Detail :");
                System.out.println(emp);
                return;
            }
            
        }
        System.out.println("Employee not found!!!");
    }
    public void printEmployeeList(){
        int i =0;
        System.out.println("The size of list  = "+ empList.size());
        for(Object emp : empList)
        {
            System.out.printf("--------Number %d---------",++i);
            System.out.println(emp);
        }
    }
}
