/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numbers;

/**
 *
 * @author xhunt
 */
public class WrapperDemo {
    static void abc(){
        
    }
    public static void main(String[] args) {
        abc();
        int n = 7;
        Integer intObj = new Integer(5);
        System.out.println(intObj);
        System.out.println(intObj.toString());
        intObj = n;   //boxing
        System.out.println(intObj);
        intObj =5;
        System.out.println();
        int y = intObj*2;   //unboxing
        int z = intObj.intValue();
        System.out.println("y = "+ y + " z = "+z);
        n =  Integer.parseInt("1234");
        System.out.println("n = "+ n);
        n = Integer.parseInt("1A",16);
        System.out.println("n= "+n);
        
        System.out.println(intObj);
        
        
    }
}
