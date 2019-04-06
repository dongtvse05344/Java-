/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package balo;

/**
 *
 * @author xhunt
 */
public class Thing {
    public int w;
    public int b;

    public Thing(int w, int b) {
        this.w = w;
        this.b = b;
    }
    
    public void print()
    {
        System.out.println("["+w+","+b+"]");
    }
    
}
