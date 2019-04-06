/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv;

/**
 *
 * @author xhunt
 */
public class Test {
    public static void main(String[] args) {
        Rectangle rectangle1 = new Rectangle(" Tía ", "blue", 3, 4 );
        rectangle1.showRetangle();
        Rectangle rectangle2 = new Rectangle(" Má ", "blue", 3, 6 );
        rectangle2.showRetangle();
        Rectangle rectangle3 = new Rectangle(" No one ", "orange", 5, 7 );
        rectangle3.showRetangle();
        Rectangle rectangle4 = new Rectangle(" No one ", "yellow", 8, 9 );
        rectangle4.showRetangle();
     
        rectangle1.setOwner("Ghệ anh 2 ");
        rectangle1.setColor("Pink");
        rectangle1.getOwner();
        System.out.println("print computerPrimeter:");
        rectangle1.computerPrimeter();
        rectangle1.computerArea();
        System.out.println("Print get name rectangle 1 : " +rectangle1.getOwner());
        System.out.println("print get name rectangle 1 : "+rectangle1.getColor());
        rectangle2.computerPrimeter();
        rectangle2.computerArea();
        rectangle3.computerPrimeter();
        rectangle3.computerArea();
        rectangle4.computerPrimeter();
        rectangle4.computerArea();
        System.out.println("========Using toString=============");
        System.out.println(rectangle1.toString());
        System.out.println(rectangle2.toString());
        System.out.println(rectangle3.toString());
        System.out.println(rectangle4.toString());
        
        
        Disk disk1 = new Disk(" Anh 2 ","yellow", "no", 4);
        Disk disk2 = new Disk(" Ghệ anh 2 "," blue "," yes ", 3);
        Disk disk3 = new Disk("No one", "red", "", 7);
        Disk disk4 = new Disk("No one", "red", "", 3);
        disk1.computerArea();
        disk1.computerPrimeter();
        disk2.setcolor("blue");
        disk2.getcolor();
        System.out.println("print get name disk 2: " +disk2.getcolor());

        disk2.computerPrimeter();
        disk2.computerArea();
        
        
        disk3.computerPrimeter();
        disk3.computerArea();
        disk4.computerPrimeter();
        disk4.computerArea();
        System.out.println("===================================================== Using toString ==========================================================");
        System.out.println(disk1.toString());
        System.out.println(disk2.toString());
        System.out.println(disk3.toString());
        System.out.println(disk4.toString());
    }
}

