/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringpool;

import java.util.Scanner;

/**
 *
 * @author xhunt
 */
public class StringDemo_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String or,re, rement;
        System.out.print("Enter original string :");
        or = sc.nextLine();
        System.out.print("Enter replaced string :");
        re = sc.nextLine();
        System.out.print("Enter replacing string :");
        rement = sc.nextLine();
        or = or.replace(re, rement);
        System.out.println("After replacing: "+or);
        System.out.println("Uppercase : "+or.toUpperCase());
        System.out.println("Origin :" +or);
        System.out.println("Enter the index of extracted charater :");
        int index = Integer.parseInt(sc.nextLine());
        System.out.format("The %d(th) character:%c\n",index,or.charAt(index));
    }
}
