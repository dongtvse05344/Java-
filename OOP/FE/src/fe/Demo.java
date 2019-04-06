/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fe;

/**
 *
 * @author xhunt
 */
 class AX {
    static int N = 10;
    static String S = "Hello";
    int x = 5;
    static{ N = 7; S = "GO";}
    void print(){
        S="TO";
        System.out.println(S+N+x);
    }
 
}

public class Demo
{
    public static void main(String[] args) {
        System.out.print(AX.S);
        AX t = new AX();
        t.print();
        System.out.println("");
    }
}
