/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dequeDemo;

import java.util.LinkedList;

/**
 *
 * @author xhunt
 */
public class DequeDemo {
    public static void main(String[] args) {
        int n=5;
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();
        LinkedList list3 = new LinkedList();
        for(int i =0;i<=n;i++)
        {
            list1.add(i);
            list2.add(i);
            list3.add(i);
        }
        while(!list1.isEmpty()) System.out.print(list1.remove()+ ", ");
        System.out.println();
        while(!list2.isEmpty()) System.out.print(list2.removeFirst()+ ", ");
        System.out.println();
        while(!list3.isEmpty()) System.out.print(list3.removeLast()+ ", ");
        System.out.println();
    }
}
