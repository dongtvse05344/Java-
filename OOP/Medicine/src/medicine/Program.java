/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medicine;

/**
 *
 * @author xhunt
 */
public class Program {
    public static void main(String[] args) {
        Medicine med = new Medicine();
        med.Accept();
        med.IncreaseQuanlity(50);
        System.out.println("Test the first() method");
        med.Print();
        System.out.println("\nTest the second() method");
        med.Print("code");
        System.out.println("\nTest the third() method");
        med.Print("code","name");
    }
}
