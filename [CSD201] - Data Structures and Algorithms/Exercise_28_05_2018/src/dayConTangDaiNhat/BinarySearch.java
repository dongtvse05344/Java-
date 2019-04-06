/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dayConTangDaiNhat;

import java.util.Scanner;

/**
 *
 * @author xhunt
 */
public class BinarySearch {
    int n,ans;
    int[] a = new int[30010];
    int[] f = new int[30010];
    public void Input()
    {
        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            a[i] =sc.nextInt();
            
        }
    }
    
    public void Update(int x)
    {
        int l =0 ;
        int r = ans ;
        int m = (l+r)/2;
        while(m<r && !(f[m]<x && f[m+1]>x))
        {
            if (f[m]<x) l = m +1; else r = m ;
            m =(l+r)/2;
        }
        if(m ==ans) ans++;
        f[m+1] =x;
    }
    
    public void Doing()
    {
        Input();
        for (int i = 0; i < n; i++) {
            Update(a[i]);
        }
        System.out.println(ans);
    }
    
    public static void main(String[] args) {
        BinarySearch b = new BinarySearch();
        b.Doing();
    }
}
