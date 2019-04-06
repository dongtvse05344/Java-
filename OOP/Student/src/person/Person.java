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
public class Person {
    private String code ="", name ="";
    private int age =0;
    // contructors
    public Person(){
        
    }
    public Person(String c, String n, int a)
    {
        code = c;
        name = n;
        age = a >0 ?a :0;
    }
    //geter seter

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    public void input(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter code : ");
        code = sc.nextLine();
        System.out.print("Enter name : ");
        name = sc.nextLine();
        System.out.print("Enter age : ");
        age = Integer.parseInt(sc.nextLine());
    }
    public void input(String code){
        Scanner sc = new Scanner(System.in);
        this.code = code;
        System.out.print("Enter name : ");
        name = sc.nextLine();
        System.out.print("Enter age : ");
        age = Integer.parseInt(sc.nextLine());
    }
    
    public String toString()
    {
        return code + ", " +name + ", " + age ;
    }
            
    
    
}
