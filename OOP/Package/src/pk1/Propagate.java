/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pk1;

import java.util.Scanner;

/**
 *
 * @author xhunt
 */


class InvalidAge extends Exception{
    public InvalidAge(String mes)
    {
        super(mes);
    }
}

class MyClass{
    public void MyMethod(int a) throws InvalidAge{
        if(a<0)
            throw new InvalidAge("Age invalid!");
    }
}


public class Propagate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean cont ;
        try {
            MyClass cl1 = new MyClass();
            cl1.MyMethod(5);
        }
        catch(InvalidAge ex)
        {
            System.out.println(ex.getMessage());
        }

    }
}
