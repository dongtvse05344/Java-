/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author xhunt
 */
public class StudentTest {
    Scanner sc = new Scanner(System.in);
    String ID,FullName,Address,Phone;
    Date DoB = null;
    StudentManager stdManager = new StudentManager();
    
    int choice()
    {
        System.out.println("Select a function !");
        System.out.println("1.Add new a student");
        System.out.println("2.View student list");
        System.out.println("3.Find a student by ID");
        System.out.println("4.Update a student");
        System.out.println("5.Exit");
        System.out.print("Select :");
        int c = Integer.parseInt(sc.nextLine());
        return c;
    }
    void Add()
    {
        System.out.print("Enter ID :");
        ID = sc.nextLine();
        System.out.print("FullName :");
        FullName = sc.nextLine();
        do
        {
            System.out.print("DoB(dd/mm/YYYY) :");
            SimpleDateFormat f = new SimpleDateFormat("dd/mm/YYYY");
            try {
                DoB = f.parse(sc.nextLine());
                break;
            }
            catch(Exception ex)
            {
                System.out.println("Please enter correct format !");
            }
        } while(true);
        
        System.out.print("Address :");
        Address = sc.nextLine();
        System.out.print("Phone :");
        Phone = sc.nextLine();
        if( stdManager.checkID(ID) ==0)
        {
            Student _ = new Student(ID, FullName, DoB, Phone, Address);
            stdManager.addStudent(_);
        }
        else
        {
            System.out.println("ID existed !");
        }
        
    }
    void Find()
    {
        System.out.print("Enter ID :");
        String ID = sc.nextLine();
        stdManager.getStudentByIndex(stdManager.findStudent(ID));
    }
    void Update()
    {
        System.out.print("Enter ID :");
        ID = sc.nextLine();
        System.out.print("FullName :");
        FullName = sc.nextLine();
        do
        {
            System.out.print("DoB(dd/mm/YYYY) :");
            SimpleDateFormat f = new SimpleDateFormat("dd/mm/YYYY");
            try {
                DoB = f.parse(sc.nextLine());
                break;
            }
            catch(Exception ex)
            {
                System.out.println("Please enter correct format !");
            }
        } while(true);
        System.out.print("Address :");
        Address = sc.nextLine();
        System.out.print("Phone :");
        Phone = sc.nextLine();
        Student _ = new Student(ID, FullName, DoB, Phone, Address);
        stdManager.updateStudent(_);
    }
    public static void main(String[] args) {
        int c;
        
        StudentTest st = new StudentTest();
        
        do {
            c = st.choice();
            switch(c)
            {
                case 1: st.Add(); break;
                case 2: st.stdManager.printStudentList(); break;
                case 3: st.Find(); break;
                case 4: st.Update(); break;
                case 5: System.exit(0); break;
                default :
                    System.out.println("Please try again !");
                    break;
            }
        } while(true);
    }
}
