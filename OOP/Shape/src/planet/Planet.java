/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planet;

/**
 *
 * @author xhunt
 */
public enum Planet {
    // Enum for some planets ( mass, radious)
    MERCURY ( 3.303e+23,2.4397e6);
    private final double mass;      //in kilograms
    private final double radius;    // in meters
    Planet( double mass, double radius)
    {
        this.mass = mass;
        this.radius =  radius;
    }

    public static Planet getMERCURY() {
        return MERCURY;
    }

    public double getMass() {
        return mass;
    }

    public double getRadius() {
        return radius;
    }
    
    
}
