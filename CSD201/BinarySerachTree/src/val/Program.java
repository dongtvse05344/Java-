/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package val;

import binaryserachtree.*;

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
        int a[] = {5,2,7,1,4,3,9};
        Tree b = new Tree();
        for (int i = 0; i < a.length; i++) {
            b.add(a[i]);
        }
        System.out.println("LNR - Inorder - Infix");
        b.inorder(b.root);
        System.out.println("");
        
        System.out.println("LRN - Postorder - Postfix");
        b.postorder(b.root);
        System.out.println("");
        
        System.out.println("NLR - Preorder - Prefix");
        b.preorder(b.root);
        System.out.println("");
        
        System.out.println("Count leaf : " + b.countLeaf(b.root));
        System.out.println("Count 1 child : "+ b.count1Child(b.root));
        System.out.println("Count 2 child : " +b.count2Child(b.root));
        System.out.println("Height : " + b.calHeight(b.root));
        b.BFS(b.root);
        
        System.out.println("Right most : " + b.rightNodeMost(b.root).data);
        System.out.println();
        System.out.println("Distance bettween 1 & 3 : " + b.Distance(b.getNode(1), b.getNode(3)));
        System.out.println("Distance bettween 3 & 9 : " + b.Distance(b.getNode(3), b.getNode(9)));
        
        b.deleteNodebyCopy(b.root);
        b.BFS(b.root);
        
    }
    
    
}
