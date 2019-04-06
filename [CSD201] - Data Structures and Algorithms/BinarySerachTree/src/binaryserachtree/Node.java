/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binaryserachtree;

/**
 *
 * @author xhunt
 */
public class Node{
    protected int data;
    protected Node l,r;

    

    public Node(int data, Node l, Node r) {
        this.data = data;
        this.l = l;
        this.r = r;
    }

    public Node(int data) {
        this(data,null,null);
    }
    
    
}
