/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package box;

/**
 *
 * @author xhunt
 */
class Box {

    int length = 0;
    int width = 0;
    protected int depth = 0;

    public Box() {
    }

    public Box(int l) {
        length = l > 0 ? l : 0;
    }

    public Box(int l, int w) {
        length = l > 0 ? l : 0;
        width = w > 0 ? w : 0;
    }

    public void setEdge(int l, int w) {
        length = l > 0 ? l : 0;
        width = w > 0 ? w : 0;
    }

    public void setEdge(int l, int w, int d) {
        length = l > 0 ? l : 0;
        width = w > 0 ? w : 0;
        depth = d > 0 ? d : 0;
    }

    public void output() {
        String s = "[" + length + "," + width + "," + depth + "]";
        System.out.println(s);
    }
}

public class BoxUse {

    public static void main(String[] args) {
        Box box = new Box();
        box.depth = 4;
        box.output();
        box.setEdge(7, 3);
        box.output();
        box.setEdge(90, 100, 75);
        box.output();
    }
}
