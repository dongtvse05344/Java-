/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Demo3_Anonymous;

/**
 *
 * @author xhunt
 */
public abstract class MyAdapter {
    public void M1(){
        System.out.println("M1");
    }
    
    public void M2()
    {
        System.out.println("M2");
    }
}

class Program{
    public static void main(String[] args) {
        MyAdapter obj = new MyAdapter() {
            public void M1()
            {
                System.out.println("M1 overridden");
            }
        };
        obj.M1();
        obj.M2();
    }
}
