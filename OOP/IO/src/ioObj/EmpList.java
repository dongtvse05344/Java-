    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ioObj;

import java.io.*;
import java.io.FileReader;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;

/**
 *
 * @author xhunt
 */
public class EmpList extends Vector<Employee>{
    Scanner sc = new Scanner(System.in);
    public EmpList()
    {
        super();
    }
    public void AddFromFile(String fName) throws FileNotFoundException, IOException{
        try{
            File f = new File(fName);
            if(!f.exists()) return;
            FileReader fr = new FileReader(f);
            BufferedReader bf = new BufferedReader(fr);
            String details;
            while((details= bf.readLine())!= null)
            {
                StringTokenizer stk = new StringTokenizer(details,",");
                String code = stk.nextToken().toUpperCase();
                String name = stk.nextToken().toUpperCase();
                int salary = Integer.parseInt(stk.nextToken());
                Employee emp = new Employee(code, name, salary);
                this.add(emp);
            }
            bf.close(); fr.close();
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
            File f = new File(fName);
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            for(Employee x:this)
            {
                pw.println(x.getCode()+","+x.getName()+","+x.getSalary());
            }
            pw.close(); fw.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    private int find(String aCode){
        for(int i =0 ; i<this.size();i++)
        {
            if(this.get(i).getCode().equals(aCode)) return i;
        }
        return -1;
    }
    
    public void addNewEmp()
    {
        String code,name;
        int salary;
        int pos;
        boolean valid =  true;
        System.out.println("Enter new employee details");
        do
        {
            System.out.print("    code E000:");
            code = sc.nextLine().toUpperCase();
            pos = find(code);
            valid = code.matches("^E\\d{3}$"); //Pattern E and 3 digits
            if(pos>=0) System.out.println("The code is duplicated");
            if(!valid) System.out.println("The code : E and 3 digits.");
        }
        while(pos >=0|| (!valid));
        System.out.print("   name:");
        name= sc.nextLine();
        System.out.print("   salary:");
        salary = Integer.parseInt(sc.nextLine());
        this.add(new Employee(code, name, salary));
        System.out.println("New Employee has been added");
    }
    
    public void removeEmp()
    {
        String code;
        System.out.println("Enter the code of removed employee : ");
        code = sc.nextLine().toUpperCase();
        int pos = find(code);
        if(pos<0)
        {
            System.out.println("This code does not exist.");
        }
        else
        {
            this.remove(pos);
            System.out.println("The employee "+ code+" has been removed");
        }
    }
    
    public void print()
    {
        if(this.size()==0)
        {
            System.out.println("Empty list.");
            return ;
        }
        Collections.sort(this);
        System.out.println("\nEMPLOYEE LIST");
        System.out.println("---------------------------");
        for(Employee x:this)x.print();
    }
}
