/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chuoiconchungdainhat;

import java.util.Scanner;

/**
 *
 * @author xhunt
 */
public class chuoiConChung {
    String a,b;
    int[][] f = new int[1000][1000];
    
    public void Input()
    {
        Scanner sc = new Scanner(System.in);
       a = sc.nextLine();
       b = sc.nextLine();
    }
    
    public int getAns()
    {
        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                int p = a.charAt(i-1) == b.charAt(j-1) ? 1:0;
                f[i][j] = Math.max(Math.max(f[i][j-1], f[i-1][j]),f[i-1][j-1]+p);
            }
        }
        return f[a.length()][b.length()];
    }
    
    public void Doing()
    {
        Input();
        System.out.println(getAns());
    }
    
    public static void main(String[] args) {
        chuoiConChung c = new chuoiConChung();
        c.Doing();
    }
}
