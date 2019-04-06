/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lca;

import graph.Graph;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author xhunt
 */
public class LCA {
    Graph graph = null;
    int l[]; 
    int P[][];
    int root;
    int n;
    private void init(int n )
    {  
        graph = new Graph(n);
        l = new int[n];
        P = new int[20][n];
    }
    public LCA()
    {
       
    }
    
    private int level(int x)
    {
        if(x == root) return l[x]= 1;
        if(l[x] == 0) l[x] = level(P[0][x]) +1;
        return l[x];
    }
    
    public void input()
    {
        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(sc.nextLine());
        init(n+1);
        for (int i = 1; i <= n; i++) {
            String s = sc.nextLine();
            StringTokenizer stk = new StringTokenizer(s, " ");
            int m = Integer.parseInt(stk.nextToken());
            for (int j = 0; j < m; j++) {
                int q = Integer.parseInt(stk.nextToken());
                graph.addEdge(i, q, 0);
                graph.addEdge(q, i, 0);
                P[0][q] = i;
            }
        }
        
        for (int i = 1; i <=n; i++) {
            if(P[0][i] ==0) root = i;
        }
        for (int i = 1; i <= n; i++) {
            level(i);
        }
        
        for (int k = 1; k <= 19; k++) {
            for (int i = 1; i <= n; i++) {
                P[k][i] = P[k-1][P[k-1][i]];
            }
        }
    }
    
    public int LCAFunc(int x, int y)
    {
        for (int k = 19; k >= 0; k--) {
            if(l[P[k][x]]>= l[y])
            {
                x= P[k][x];
            }
        }
        for (int k = 19; k >= 0; k--) {
            if(l[P[k][y]]>= l[x])
            {
                y= P[k][y];
            }
        }
        while(x!= y)
        {
            x=P[0][x]; y = P[0][y];
        }
        return x;
    }
    
    public void print()
    {
        graph.print();
    }
    
    
}
