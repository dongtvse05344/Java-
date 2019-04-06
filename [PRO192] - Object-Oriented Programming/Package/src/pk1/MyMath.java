/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pk1;

import java.*;

/**
 *
 * @author xhunt
 */
public class MyMath {
    public static void main(String[] args) {
        int x =6,y=0;
        try {
            System.out.println(x/y);
        }
        catch( ArithmeticException e)
        {
            System.out.println(e);
            y=2;
        }
        finally
        {
            System.out.println("Hello");
            System.out.println(x/y);
        }
        
    }
}
