/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.pkg1;

import java.util.Scanner;

/**
 *
 * @author xhunt
 */
public class Lab1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        float s = 0;
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            float x = sc.nextFloat();
            s +=x;
        }
        System.out.println("Result :" + s);
        System.out.println("Average :" + s/5);
    }
    
}
