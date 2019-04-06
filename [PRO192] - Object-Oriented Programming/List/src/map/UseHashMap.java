/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package map;

import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author xhunt
 */
public class UseHashMap {
    public static void main(String[] args) {
        HashMap mymap = new HashMap();
        mymap.put(1,"One");
        mymap.put(2,"Two");
        mymap.put(3,"Three");
        mymap.put(4,"Four");
        //using Iteratoor
        Iterator it= mymap.keySet().iterator();
        while(it.hasNext()){
            Object key = it.next();
            System.out.println(key+": "+ mymap.get(key));
        }
    }
}
