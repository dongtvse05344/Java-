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
public class PersonList {
    private Person[] list = null;
    private int count = 0;

    public PersonList(int size) {
        size = size < 10 ? 10 : size;
        list = new Person[size];
    }
    
    int find(String aCode)
    {
        for (int i = 0; i < count; i++) {
            if(aCode.equals(list[i].getCode())) return i;
        }
        return -1;
    }
    
    public void add(){
        if ( count == list.length) 
        {
            System.out.println("List is full !");
            return ;
        }
        Person p = new Person();
        p.input();
        list[count++] = p;
        System.out.println("New person have been added");
    }
    
    public void remove(){
        if(count ==0) {
            System.out.println("List is empty");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter code of removed person");
        String remove = sc.nextLine();
        int pos = find(remove);
        if(pos < 0) 
        {
            System.out.println("The person does not exist.");
            return ;
          }
        for(int i = pos;i< count ;i++)
        {
            list[i] = list[i+1];
        }
        count --;
        System.out.println("The person "+remove +"was removed");
    }
    
    public void update(){
        if(count ==0) {
            System.out.println("List is empty");
            return;
        }
        System.out.println("Enter a code :");
        Scanner sc = new Scanner(System.in);
        String code =  sc.nextLine();
        int pos = find(code);
        if(pos < 0)
        {
            System.out.println("This person does not existed");
            return;
        }
        Person p = new Person();
        p.input(code);
        list[pos] = p;
    }
    
    public void print()
    {
        if(count==0)
        {
            System.out.println("List is empty");
            return;
        }
        System.out.println("LIST OF PERSON :");
        for(int i =0;i< count ;i++)
        {
            System.out.println(list[i].toString());
        }
    }
    
    public void sort()
    {
        if(count==0) return;
        for(int i =0;i<count-1;i++)
        {
            for(int j = i+1; j< count;j++)
            {
                if(list[i].getAge()> list[j].getAge())
                {
                    Person p= list[i];
                    list[i] = list[j];
                    list[j] = p;
                }
            }
        }
    }
    
}
