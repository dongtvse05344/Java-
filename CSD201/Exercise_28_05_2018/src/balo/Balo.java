/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package balo;

import java.util.Scanner;

/**
 *
 * @author xhunt
 */
public class Balo {
    
    private int n,m;
    int[][] f = new int[100][100];
    Thing[] t = new Thing[10010];
    
    public void Input()
    {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            t[i] = new Thing(sc.nextInt(), sc.nextInt());
        }
    }
    
    public void QHD()
    {
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                f[i][j] = f[i-1][j];
                if(j >=t[i].w)
                {
                   f[i][j]= Math.max(f[i-1][j],f[i-1][j-t[i].w]+ t[i].b);
                }
            }
        }
        System.out.println(f[n-1][m-1]);
    }
    
    public void Doing()
    {
        Input();
        QHD();
    }
}
