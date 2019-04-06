/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author xhunt
 */
public class Graph {

    static boolean[] visited;
    // Array  of lists for Adjacency List Representation
    static LinkedList<Node> adj[];
    float[] val;
    int[] pre;
    int n;  // No. of vertices
    final float oo = Float.MAX_VALUE;

    private void init() {
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            visited[i] = false;
        }

        val = new float[n];
        for (int i = 0; i < n; i++) {
            val[i] = oo;
        }
        pre = new int[n];

    }

    // Constructor
    public Graph(int v) {
        n = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList();
        }
        init();

    }

    public Graph() {
        input();
    }

    public void addEdge(int v, int dest, float cost) {
        Node t = new Node(dest, cost);
        adj[v].add(t);  // Add w to v's list.
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        StringTokenizer stk = new StringTokenizer(s, " ");
        n = Integer.parseInt(stk.nextToken()) + 1;
        adj = new LinkedList[n];
        for (int i = 0; i < n; ++i) {
            adj[i] = new LinkedList();
        }
        int k = Integer.parseInt(stk.nextToken());
        for (int i = 1; i < n; i++) {
            s = sc.nextLine();
            stk = new StringTokenizer(s, " ");
            int t = Integer.parseInt(stk.nextToken());
            for (int j = 0; j < t; j++) {
                int dest = Integer.parseInt(stk.nextToken());
                addEdge(i, dest, 0);
            }
        }
        DFS(k);
    }

    public void DFS(int x) {
        int count = 0;
        init();
        DFSFunc(x);
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                count++;
            }
        }
        System.out.println(count);
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println("");
    }

    public void DFSFunc(int x) {
        visited[x] = true;
        for (int i = 0; i < adj[x].size(); i++) {
            int dest = adj[x].get(i).dest;
            if (!visited[dest]) {
                DFSFunc(dest);
            }
        }
    }

    public void BFSFunc(int x) {
        init();
        LinkedList<Integer> stack = new LinkedList<>();
        stack.add(x);
        while (!stack.isEmpty()) {
            int cur = stack.get(0);
            stack.removeFirst();
            for (int i = 0; i < adj[cur].size(); i++) {
                int dest = adj[x].get(i).dest;
                if (!visited[dest]) {
                    stack.add(dest);
                    visited[dest] = true;
                }
            }
        }
    }

    public void print() {
        System.out.println(n);
        for (int i = 0; i < n; i++) {
            System.out.print(i + " : ");
            for (int j = 0; j < adj[i].size(); j++) {
                System.out.print(adj[i].get(j).dest + " ");
            }
            System.out.println("");
        }
    }
}
