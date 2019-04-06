/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package person;

import java.util.Vector;

/**
 *
 * @author xhunt
 */
class Person2 {
    String name; int age;
    Person2(String n,int a)
    {
        name = n; age = a;
    }
    void print(){
        System.out.println(name + ", "+ age);
    }
}
public class Generic2 {
    public static void main(String[] args) {
        Vector<Person2> v = new Vector<Person2>();
        v.add(new Person2("Hoa",23));
        v.add(new Person2("Tuấn",27));
        for(int i =v.size()-1;i>=0;i--)
        {
            v.get(i).print();
        }
    }
}
