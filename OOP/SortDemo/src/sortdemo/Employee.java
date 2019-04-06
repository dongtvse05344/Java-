/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortdemo;

import java.util.Comparator;

/**
 *
 * @author xhunt
 */
public class Employee implements Comparable{
    String ID="", name ="";
    int salary=0;

    public Employee(String id, String n, int s) {
        ID= id;
        name = n;
        salary = s;
    }
    
    @Override
    public String toString(){
        return ID + ", " + name +", " + salary;
    }
    @Override // standard comparing
    public int compareTo(Object t) {
        return ID.compareTo(((Employee)t).ID);
    }
    
    public static Comparator compareObj = new Comparator(){
        @Override
        public int compare(Object t, Object t1) {
            Employee emp1 = (Employee) t;
            Employee emp2 = (Employee) t1;
            int d =  emp1.salary - emp2.salary;
            if(d > 0) return -1;
            if(d ==0) return emp1.ID.compareTo(emp2.ID);
            return 1;
        }  
    };
}
