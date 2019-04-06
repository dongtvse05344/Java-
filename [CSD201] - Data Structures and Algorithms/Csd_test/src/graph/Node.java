/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

/**
 *
 * @author xhunt
 */
public class Node {
    public int dest;
    public float cost;

    public Node(int dest, float cost) {
        this.dest = dest;
        this.cost = cost;
    }
}
