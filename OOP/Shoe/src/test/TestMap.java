/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.Scanner;
import manager.ShoeManager;
import manager.ShoeManagerByMap;
import shoe.Shoe;
import shoe.SneakerShoe;

/**
 *
 * @author xhunt
 */
public class TestMap {
    static int choice()
    {
        Scanner sc = new Scanner(System.in);
        return(Integer.parseInt(sc.nextLine()));
    }
    public static void main(String[] args) {
        
        ShoeManagerByMap shoes = new ShoeManagerByMap();
        Scanner sc = new Scanner(System.in);
        
        int choice;
        do
        {
           choice = choice();
           switch(choice)
           {
               
               case 1 : 
                        
                        int x;
                        Double y;
                        x = Integer.parseInt(sc.nextLine());
                        y = Double.parseDouble(sc.nextLine());
                        SneakerShoe shoe = new SneakerShoe(x,"aa",'z',y,2);
                        shoes.add(shoe); break;
               case 2 : shoes.Sort(); break;
               case 3 : shoes.ShowList(); break;
               case 4 : 
                        int x1;
                        Double y1;
                        x = Integer.parseInt(sc.nextLine());
                        y = Double.parseDouble(sc.nextLine());
                        SneakerShoe shoe1 = new SneakerShoe(x,"aa",'z',y,2);
                        shoes.edit(shoe1); break;
               case 5 : 
                        //shoes.SortById();
                        int x2 = Integer.parseInt(sc.nextLine());
                        Shoe temp = shoes.find(x2);
                        if(temp != null)
                        {
                            temp.PrintShoe();
                        }
           }
        }
        while(choice !=6);
    }
}
