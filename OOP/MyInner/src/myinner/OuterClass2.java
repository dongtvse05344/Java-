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
public class OuterClass2 {
    int x =5;
    class Inner1 {
        int y =1;
        public void print(){
            System.out.println(y);
        }
    }
    public class Inner2 {
        int z = 2;
        public void print(){
            System.out.println(z);
        }
    }
}
