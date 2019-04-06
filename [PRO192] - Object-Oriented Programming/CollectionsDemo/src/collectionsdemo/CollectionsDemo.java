/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collectionsdemo;


import java.util.*;

/**
 *
 * @author xhunt
 */
public class CollectionsDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList ar = new ArrayList();
        Vector v = new Vector();
        Random rd = new Random();
        for(int i=1 ;i <= 10;i++)
        {
            ar.add(rd.nextInt(30));
            v.add(rd.nextInt(30));
        }
        System.out.println("ar = " + ar);
        System.out.println("v = " +v);
        boolean dis = Collections.disjoint(ar, v);
        System.out.println("ar and v is disjunct : " + dis);
        Collections.addAll(v, ar.toArray());
        System.out.println("After adding, v = "+v);
        int minVal = (int)Collections.min(v);
        int maxVal = (int)Collections.max(v);
        System.out.println(minVal + " "+maxVal);
        System.out.println("occurences of 8 : "+ Collections.frequency(v, 8));
        Collections.sort(v);
        System.out.println("After sorting, v = "+v);
        int pos = Collections.binarySearch(v, 8);
        System.out.println("Position of 8: "+ pos);
        Collections.shuffle(v);
        System.out.println("After shuffling, v = "+v);
    }
    
}
