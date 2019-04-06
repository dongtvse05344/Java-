/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cj_asm_day_2;

import java.util.Scanner;

/**
 *
 * @author xhunt
 */
public class CJ_ASM_Day_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int pack,distance,shift,feedback,call,electric,other;
        double salary;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter package number : ");
        pack = sc.nextInt();
        System.out.print("Enter distance number :");
        distance = sc.nextInt();
        System.out.println("Enter shift number :");
        shift = sc.nextInt();
        System.out.print("Enter feedback grade :");
        feedback = sc.nextInt();
        System.out.print("Enter the call amount :");
        call = sc.nextInt();
        System.out.print("Enter the electricity payment :");
        electric = sc.nextInt();
        System.out.print("Enter the other payment :");
        other = sc.nextInt();
        salary = pack*50 + distance *75+shift*50*0.1+feedback+ call+electric+other;
        System.out.println("The salary is "+ salary);
    }
    
}
