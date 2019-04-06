/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphdemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 *
 * @author xhunt
 */
public class Graph {
    String filename = "input.txt";
    int n;
    final int maxN = 1000;
    int a[][] =new int[maxN][maxN];
    int d[] = new int[maxN];

    public Graph() throws IOException {
        loadData();
    }
    
    
    
    public void loadData() throws FileNotFoundException, IOException
    {
        File f = new File(filename);
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        StringTokenizer stk = null;
        
        n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            stk = new StringTokenizer(br.readLine()," ");
            for (int j = 1; j <= n; j++) {
                a[i][j] = Integer.parseInt(stk.nextToken());
                d[i] += a[i][j];
            }
        }
    }
    
    public void printDeg()
    {
        for (int i = 1; i <= n; i++) {
            System.out.println("Deg " + i + " : " + d[i]);
        }
    }
    
    public int valueofMainDiagonalLine()
    {
        int res= 0;
        for (int i = 1; i <=n; i++) {
            res += a[i][i];
        }
        return res;
    }
    
    public int valueofBoxderBox()
    {
        int res =0;
        for (int i = 1; i <= n; i++) {
            res += a[1][i];
            if(n >1 ) res += a[n][i];
        }
        
        for (int i = 2; i <= n-1; i++) {
            res += a[i][1];
            if(n >1 ) res += a[i][n];
        }
        
        return res;
    }
            
    
}
