/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

import java.util.Iterator;
import java.util.Random;
import java.util.TreeSet;

/**
 *
 * @author xhunt
 */
public class Student implements Comparable{
    
    private String name;
    private int id;
    public Student(int id, String name)
    {
        this.name =  name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @Override
    public int compareTo(Object t) {
        Student s = (Student)t;
        if(id > s.getId()){
            return 1;
        }
        else
        {
            if(id == s.getId())
            { 
                return 0;
            }
            else {
                return -1;
            }
        }
    }
    
    public static void main(String[] args) {
        int id;
        Random r = new Random();
        TreeSet myset = new TreeSet();
        for(int i = 1; i<= 10;i++)
        {
            id = r.nextInt(100);
            Student st = new Student(id,"Student "+i);
            myset.add(st);
        }
        
        //using iterator
        Iterator it = myset.iterator();
        while(it.hasNext())
        {
            Student st = (Student)it.next();
            System.out.println("ID: "+ st.getId()+", Name : "+st.getName());
        }
    }
    
}
