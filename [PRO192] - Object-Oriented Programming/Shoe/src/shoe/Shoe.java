/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoe;

import java.util.Comparator;

/**
 *
 * @author xhunt
 */
public abstract class Shoe {
    public int Id;
    protected String Name;
    protected char Size;
    protected Double price;
    protected int Quantity;
    public abstract void PrintShoe();

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public char getSize() {
        return Size;
    }

    public void setSize(char Size) {
        this.Size = Size;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public Shoe(int Id, String Name, char Size, Double price, int Quantity) {
        this.Id = Id;
        this.Name = Name;
        this.Size = Size;
        this.price = price;
        this.Quantity = Quantity;
    }
    
    
    
}
