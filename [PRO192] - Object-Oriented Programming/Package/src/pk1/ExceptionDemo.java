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
public class ExceptionDemo {
    public int divide1(int a,int b) throws ArithmeticException
    {
        return a/b;
    }
    
    public int divide2(int a, int b)
    {
        if(b==0) throw new ArithmeticException("Hey, Demo1nator: 0");
        return a/b;
    }
    
    public static void main(String[] args) {
        ExceptionDemo ex = new ExceptionDemo();
        int a= 6, b=0;
        try{
            System.out.println(ex.divide1(a, b));
        }
        catch(ArithmeticException e)
                {
                    System.out.println(e);
        }
    }
}
