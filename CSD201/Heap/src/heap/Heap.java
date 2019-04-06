/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heap;

import java.util.ArrayList;



/**
 *
 * @author xhunt
 */
public class Heap {

    int[] a ;
    int n ;

    public Heap() {
        a = new int[500];
        n = 0;
    }
    private void swap(int  x,int y)
    {
        int t = a[x];
        a[x] = a[y];
        a[y] =t;
    }
    
    public int get()
    {
        return a[0];
    }
    
    public int remove()
    {
        int res = a[0];
        swap(0,n-1);
        n--;
        int temp = 0;
        while(temp <n)
        {
            int t = temp*2 + 1;
            if(t >= n) break;
            
            if(temp*2+2 < n && a[temp*2+1] < a[temp*2+2])
            {
               t +=1;
            }
            if(a[t] > a[temp])
            {
                swap(t,temp);
                temp = t;
                continue;
            }
            break;
        }
        return res;
    }
    
    public void add(int el)
    {
        a[n++] = el;
        int temp = n-1;
        while(temp > 0)
        {
            if(a[temp] > a[(temp-1)/2])
            {
                swap(temp,(temp-1)/2);
                temp = (temp -1)/2;
                continue;
            }
            break;
        }
    }
    
    public void print()
    {
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] +" ");
        }
        System.out.println("");
    }
    
    
    
}
