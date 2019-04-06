/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medicine;

import java.util.Scanner;

/**
 *
 * @author xhunt
 */
public class Medicine {
    private String code;
    private String name;
    private String manufacturer ;
    private int price;
    private int quanlity;
    private String date;
    private String expireDate;
    private int batchNumber;

    
    public Medicine() {
        this.code = null;
        this.name = null;
        this.manufacturer = null;
        this.price = 0;
        this.quanlity = 0;
        this.date = null;
        this.expireDate = null;
        this.batchNumber = 0;
    }
    
    public Medicine(String code, String name, String manufacturer, int price, int quanlity, String date, String expireDate, int batchNumber) {
        this.code = code;
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
        this.quanlity = quanlity;
        this.date = date;
        this.expireDate = expireDate;
        this.batchNumber = batchNumber;
    }
    
    public void Accept()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the medicine code :");
        code = sc.nextLine();
        System.out.print("Enter the medicine name :");
        name = sc.nextLine();
        System.out.print("Enter the manufaturer name :");
        manufacturer = sc.nextLine();
        System.out.print("Enter the unit price :");
        price = Integer.parseInt(sc.nextLine());
        System.out.print("Enter the quality on hand :");
        quanlity = Integer.parseInt(sc.nextLine());
        System.out.print("Enter the manufactured date :");
        date = sc.nextLine();
        System.out.print("Enter the expiry date :");
        expireDate = sc.nextLine();
        System.out.print("Enter the batch number :");
        batchNumber = Integer.parseInt(sc.nextLine());
    }
    
    public void IncreaseQuanlity(int number)
    {
        quanlity += number;
    }
    
    public void Print()
    {
        System.out.println("***** The Medicine Detail ******");
        System.out.println("Medicine code: "+ code);
        System.out.println("Medicine name: "+name);
        System.out.println("Manufacturer name : "+ manufacturer);
        System.out.println("The unit price: "+price);
        System.out.println("The quanlity on hand :"+quanlity);
        System.out.println("The manufactured date: "+date);
        System.out.println("The expiry date: "+expireDate);
        System.out.println("The batch number : "+ batchNumber);
    }
    
    public void Print(String code)
    {
        System.out.println("Medicine code: "+ code);
        System.out.println("The quanlity on hand :"+quanlity);
    }
    public void Print(String code,String name)
    {
        System.out.println("Medicine code: "+ code);
        System.out.println("Medicine name: "+name);
        System.out.println("The manufactured date: "+date);
        System.out.println("The expiry date: "+expireDate);
    }
}

