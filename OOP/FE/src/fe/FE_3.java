/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fe;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author xhunt
 */
class A{
    void foo()
    {
        System.out.println("A");
    }
}
class B
{
    void foo()
    {
        System.out.println("B");
    }
}
class C extends A
{
    void foo()
    {
        System.out.println("C");
    }
}

public class FE_3 {
    public static void main(String[] args) {
//        Set<FE_3> set = new TreeSet<FE_3>();
//        set.add(new FE_3());

        String a = "XYZ";
        String b = new String("XYZ");
        if(a==b)
        {
            System.out.println("a ==b, ");
        }
        else
        {
            System.out.println("a#b");
        }
        String c = a.intern();
        System.out.println(c);
        if(c==b)
        {
            System.out.println("a ==b, ");
        }
        else
        {
            System.out.println("a#b");
        }
    }
    
}
