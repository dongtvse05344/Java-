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
public class test {
    public static void main(String[] args) {
        OuterClass2 obj = new OuterClass2();
        OuterClass2.Inner1 in1 = new OuterClass2().new Inner1();
        OuterClass2.Inner2 in2 = obj.new Inner2();
        in1.print();
        in2.print();
    }
}
