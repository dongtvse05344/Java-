/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heap;

/**
 *
 * @author xhunt
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Heap h = new Heap();
        int[] a= {5,4,1,7,2,9};
        for (int i = 0; i < a.length; i++) {
            h.add(a[i]);
        }
        h.print();
        h.remove();
        h.print();
    }
    
}
