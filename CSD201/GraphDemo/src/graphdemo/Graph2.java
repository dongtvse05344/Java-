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
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 *
 * @author xhunt
 */
public class Graph2 {
    int n;
    String  filename = "input2.txt";
    ArrayList<LinkedList<Integer>> graph = new ArrayList<>();

    public Graph2() throws IOException {
        loadData();
    }
  
    
    public void loadData() throws FileNotFoundException, IOException
    {
        
        File f = new File(filename);
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        StringTokenizer stk = null;
        String s;
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            graph.add(new LinkedList<>() );
        }
        while((s = br.readLine()) != null)
        {
            stk = new StringTokenizer(s," ");
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            graph.get(a).add(b);
        }
        
    }
    
    public void printDeg()
    {
        for (int i = 0; i < n; i++) {
            System.out.println("Deg " + i + " : " + graph.get(i).size());
        }
    }
}
