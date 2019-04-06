/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genericarray;

import java.util.Arrays;

/**
 *
 * @author xhunt
 */
public class GenericArray <T> {
    public static <T> T get (int i, T[] ar)
    {
        return ar[i];
    }
    public  <T> void output(T[] ar)
    {
        for(T x : ar) System.out.print(x+ ", ");
        System.out.println("");
    }
    
    public  <T> void sort(T[] ar)
    {
        Arrays.sort(ar);
    }
}

class GenericArrayUse {
    public static void main(String[] args) {
        Integer a[] = {1,2,3,4,5};
        GenericArray obj1  = new GenericArray();
        obj1.output(a);
        System.out.println(GenericArray.get(3,a));
        Double b[] = {1.1,2.2,3.3,4.4};
        GenericArray<Double> obj2 = new GenericArray<Double>();
        obj2.output(b);
        String list[] = {"you","love","I"};
        GenericArray<String> obj3 = new GenericArray<String>();
        obj2.output(list);
        obj2.sort(list);
        obj2.output(list);
    }
}
