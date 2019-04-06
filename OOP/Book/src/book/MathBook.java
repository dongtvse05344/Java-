/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book;

/**
 *
 * @author xhunt
 */
public class MathBook extends Book{

    @Override
    public void PrintBook() {
        System.out.println("this is math book");
    }

    public MathBook() {
    }

    @Override
    public double SubTotal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void ABC()
    {
        System.out.println("Ham rieng");
    }
    
}
