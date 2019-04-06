/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package list;

import java.util.Iterator;
import java.util.Vector;

/**
 *
 * @author xhunt
 */
public class List {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Vector vec = new Vector();
        for(int i = 101; i <= 110;i++)
        {
            vec.add(i);
        }
        for(int i = 0;i< 5; i++)
        {
            System.out.println(vec.get(i));
        }
        // or using Iterator
        Iterator iter = vec.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
    }
    
}
