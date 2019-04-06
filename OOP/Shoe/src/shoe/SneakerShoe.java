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
public class SneakerShoe extends Shoe implements Comparable{

    public SneakerShoe(int Id, String Name, char Size, Double price, int Quantity) {
        super(Id, Name, Size, price, Quantity);
    }

    @Override
    public void PrintShoe() {
        System.out.println("Id : " + Id + " Name : " + Name + " Size "  + Size + " Price : " + price + " Quantity : "+ Quantity);
    }

    @Override
    public int compareTo(Object t) {
        return Id - ((SneakerShoe)t).Id;
    }
    
    public static Comparator compareObj = new Comparator(){
        @Override
        public int compare(Object t, Object t1) {
            return (int) Math.round(((SneakerShoe)t).price - ((SneakerShoe)t1).price);
        }
    };
    
    public static Comparator compareId = new Comparator(){
        @Override
        public int compare(Object t, Object t1) {
            return ((SneakerShoe)t).Id - ((SneakerShoe)t1).Id;
        }
    };
}
