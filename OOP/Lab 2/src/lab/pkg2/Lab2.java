/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.pkg2;

import java.util.Scanner;

/**
 *
 * @author xhunt
 */
public class Lab2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int n,m;
        float s = 0;
        int a[][] = new int[100][100];
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows :");
        n = sc.nextInt();
        System.out.print("Enter number of colum :");
        m = sc.nextInt();
        System.out.println("Enter a matrix");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print("m["+i+"]["+j+"]=");
                a[i][j] = sc.nextInt();
                s = a[i][j] + s;
            }
        }
        
        
        //output
        System.out.println("Matrix inputted");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println("");
        }
        System.out.println("Sum " + s);
        System.out.println("Average " + s/(n*m));
    }
    
}
