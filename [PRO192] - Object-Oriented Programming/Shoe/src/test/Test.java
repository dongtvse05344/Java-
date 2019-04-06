/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.Scanner;
import manager.ShoeManager;
import shoe.SneakerShoe;

/**
 *
 * @author xhunt
 */
public class Test {
    static int choice()
    {
        System.out.println("1.Add new data");
        
        Scanner sc = new Scanner(System.in);
        return(Integer.parseInt(sc.nextLine()));
    }
    public static void main(String[] args) {
        
        ShoeManager shoes = new ShoeManager();
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
                        shoes.SortById();
                        int x2 = Integer.parseInt(sc.nextLine());
                        shoes.findById(x2).PrintShoe();
                        break;
               case 6 :     
                        int x3;
                         x3 = Integer.parseInt(sc.nextLine());
                         shoes.remove(x3);
                         break;
                    
           }
        }
        while(choice !=7);
    }
}
