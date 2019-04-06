/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortdemo;

import java.util.*;

/**
 *
 * @author xhunt
 */
public class SortDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Employee> list = new ArrayList<Employee>();
        list.add(new Employee("ID004","Michel",400));
        list.add(new Employee("ID001","Melen",200));
        list.add(new Employee("ID003","Genning",400));
        System.out.println("Sorting on IDs ascending");
        Collections.sort(list);
        System.out.println(list);
        System.out.println("Sorting on des salary then asc IDs");
        Collections.sort(list, Employee.compareObj);
        System.out.println(list);
    }
    
}
