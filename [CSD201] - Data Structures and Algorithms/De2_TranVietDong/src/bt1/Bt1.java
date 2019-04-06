/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bt1;

import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author xhunt
 */
public class Bt1 {
    public  LinkedList<Integer> func(LinkedList<Integer> a, LinkedList<Integer> b)
    {
        LinkedList<Integer> res = new LinkedList<>();
        int n = a.size();
        int m = b.size();
        int i = 0, j = 0;
        while(i<n && j< m)
        {
            if(a.get(i) < b.get(j))
            {
                res.add(a.get(i));
                i++;
            }
            else
            {
                res.add(b.get(j));
                j++;
            }
        }
        while(i <n)
        {
            res.add(a.get(i));
            i++;
        }
        while(j<m)
        {
            res.add(b.get(j));
            j++;
        }
        return res;
    }
    
    public static void main(String[] args) {
        LinkedList<Integer> a = new LinkedList<>();
        LinkedList<Integer> b = new LinkedList<>();
        LinkedList<Integer> c = null;
        a.add(1);
        a.add(3);
        a.add(7);
        a.add(9);
        b.add(2);
        b.add(4);
        b.add(6);
        b.add(8);
        Bt1 bt = new Bt1();
        c = bt.func(a, b);
        for (int i = 0; i < c.size(); i++) {
            System.out.print(c.get(i) + " ");
        }
    }
}
