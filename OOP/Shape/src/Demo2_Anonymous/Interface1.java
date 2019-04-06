/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Demo2_Anonymous;

/**
 *
 * @author xhunt
 */

public interface Interface1 {
    void M1();
    void M2();
}
class Anonymous{
    public static void main(String[] args) {
        Interface1 obj = new Interface1() {
            @Override
            public void M1() {
                System.out.println("M1");
            }

            @Override
            public void M2() {
                System.out.println("M2");
            }
        };
        obj.M1();
        obj.M2();
    }
}
