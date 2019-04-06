/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myinner;

/**
 *
 * @author xhunt
 */
public class OuterClass3 {
    int x;
    public static class MyInner{
        int n= 10;
        void print(){
            System.out.println(n);
        }
    }
}


