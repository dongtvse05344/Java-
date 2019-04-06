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


public class StringB {
    static void f(String t)
    {
          System.out.println("String");
    }
    static void f(StringBuffer t)
    {
        System.out.println("String buffer");
    }
    
    public static void log(String... s)
    {

    }
    
    static void doS(int x)
    {
        x = 3;
        System.out.println("DO s : "+ x++);
    }
    public static void main(String[] args) {
//        log("mess 1");
//        log("mess 1","mess 2");
//        log("mess 1","mess 2","mess 3");

          StringB sb = new StringB();
          int x =5;
          doS(x);
          System.out.println("main x = "+x );
    }
//    public static void main(String[] args) {
//        f("ABC");
//    }
}
