
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplylinkedlist;

/**
 *
 * @author xhunt
 */
public class SllNode<T> {
    public T info;
    
    public SllNode next;
    
    public SllNode(){}
    
    public SllNode(T i){
        this(i,null);
    }
    
    public SllNode(T i, SllNode n)
    {
        info = i;
        next = n;
    }
}
