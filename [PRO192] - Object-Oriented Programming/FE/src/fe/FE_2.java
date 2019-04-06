/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fe;

/**
 *
 * @author xhunt
 */
interface iF{
    
}
class cF implements iF{
    
}
class Base{
    
}

public class FE_2 extends Base{
    public static void main(String[] args) {
        FE_2 f = new FE_2();
        Base b = new Base();
        Object o =  new Object();
        iF c = new cF();
        
        o = b;
        o = c; // cha = con thi ok , con =  cha thi ko dc
      
        b= f;
    }
}
