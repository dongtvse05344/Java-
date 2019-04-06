/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bt2;

import java.util.Collections;
import java.util.LinkedList;

/**
 *
 * @author xhunt
 */
public class Bt2 {
    LinkedList<Integer> list = null;
    int Sum;
    
    
    
    public void input()
    {
        list = new LinkedList<>();
        list.add(8);
        list.add(7);
        list.add(2);
        list.add(5);
        list.add(3);
        list.add(1);
        list.add(10);
        list.add(20);
        list.add(21);
        list.add(9);
        list.add(12);
        Sum = 17;
    }
    
    public void func()
    {
        for (int i = 0; i < list.size(); i++) {         
            for (int j = i+1; j < list.size(); j++) {
                if(list.get(i) + list.get(j)== Sum)
                {
                    System.out.println("Pair found are "+ list.get(i) + " and " + list.get(j) + "( " +list.get(i)+ " +" + list.get(j) + " = " + Sum+ ")");
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Bt2 bt2 = new Bt2();
        bt2.input();
        bt2.func();
    }
}
