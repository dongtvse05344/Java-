/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

/**
 *
 * @author xhunt
 */
public class UseHashSet {
    public static void main(String[] args) {
        Random r = new Random();
        HashSet myset = new HashSet();
        for(int i=0;i<10;i++)
        {
            int number = r.nextInt(100);
            myset.add(number);
        }
        //using Iterator
        Iterator it = myset.iterator();
        while (it.hasNext())
        {
            System.out.println(it.next());
        }
    }
}
