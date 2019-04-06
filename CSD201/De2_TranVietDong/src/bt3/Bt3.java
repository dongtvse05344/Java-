/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bt3;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author xhunt
 */
public class Bt3 {
    int n,res;
    int[] a,b;
    boolean[] visited;
    public void input()
    {
        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(sc.nextLine());
        a = new int[n];
        b = new int[n];
        visited = new boolean[n];
        String s = sc.nextLine();
        StringTokenizer stk = new StringTokenizer(s, " ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(stk.nextToken());
        }
        s = sc.nextLine();
        stk = new StringTokenizer(s, " ");
        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(stk.nextToken());
        }
    }
    
    public void Func()
    {
        Arrays.sort(a);
        Arrays.sort(b);
        
        
        int i = 0, j = 0 ;
        int t;
        if(a[i] <b[j]) t = 1; else t = 2;
        while(i < n && j < n)
        {
            if(a[i] < b[j])
            {
                if(t == 2 && !visited[j-1])
                {
                    res++;
                    visited[i] = true;
                }
                t = 1;
                i++;
            }
            else
            {
                if(t == 1 && !visited[i-1])
                {
                    res++;
                    visited[j] = true;
                }
                t = 2;
                j++;
            }
        }
        if(j < n || i < n) res++;
        System.out.println(res);
    }
    
    public static void main(String[] args) {
        Bt3 bt3 = new Bt3();
        bt3.input();
        bt3.Func();
    }
}
