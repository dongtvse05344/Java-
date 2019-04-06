/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pk1;

/**
 *
 * @author xhunt
 */
public class Dog {
    private String name;

    public Dog(String name) {
        this.name = name;
    }
    
    //Method
    
    public void run()
    {
        System.out.println(name + " is running");
    }
}
