/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package introjava;

import java.util.*;

/**
 *
 * @author xhunt
 */
public class IntroJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double length,width;
        double area, cir;
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap chieu dai :");
        length = sc.nextDouble();
        System.out.print("Nhap chieu rong :");
        width = sc.nextDouble();
        area = length * width;
        cir = (length + width)*2;
        System.out.println("Area ="+area);
        System.out.println("Circumference = "+ cir);
    }
    
}
