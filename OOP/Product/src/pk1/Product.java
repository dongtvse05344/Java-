/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pk1;

/**
 *
 * @author xhunt
 */
public class Product {
    //Data member
    private String name;

    public Product(String name) {
        this.name = name;
    }
    
    //Method
    public void setProductName(String name)
    {
        this.name = name;
    }
    public String getProductName()
    {
        return name;
    }
    public void Print()
    {
        System.out.println("ProductName :" + name);
    }
}
