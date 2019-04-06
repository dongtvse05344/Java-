/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package point;

/**
 *
 * @author xhunt
 */
public class Point {

    private int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public Point() {
        this.x =1;
        this.y =1;
    }
    
    public void Print(){
        System.out.println("x:"+x+",y:"+y);
    }
    
}
