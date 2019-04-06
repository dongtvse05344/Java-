/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shape;

/**
 *
 * @author xhunt
 */
public abstract class Shape {
    abstract public double cir();
    abstract public double area();
}

class Circle extends Shape {
    double r;
    public Circle(double rr) {
        r = rr;
    }
    public double cir() {
        return 2*Math.PI*r;
    }
    public double area(){
        return Math.PI*r*r;
    }
}

class Rect extends Shape {
    double l,w;
    public Rect(double ll, double ww)
    {
        l = ll;
        w = ww;
    }
    public double cir() {
        return 2*(l+w);
    }
    public double area(){
        return l*w;
    }
}
class Program{
    public static void main(String[] args) {
    }
}
