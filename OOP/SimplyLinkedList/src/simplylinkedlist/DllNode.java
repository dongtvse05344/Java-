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
public class DllNode {
    public int info;
    
    public DllNode next;
    public DllNode pre;
    
    public DllNode(){}
    
    public DllNode(int i){
        this(i,null,null);
    }
    
    public DllNode(int i, DllNode n,DllNode p)
    {
        info = i;
        next = n;
        pre = p;
    }
}
