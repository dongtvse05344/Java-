/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package item;

import ioObj.Employee;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 *
 * @author xhunt
 */
public class ItemList extends Vector<Item> {
    Scanner sc = new Scanner(System.in);
    Vector <String> storedCodes = new Vector<String>();
    public ItemList()
    {
        super();
    }
    
    public void LoadStoredCode(String fName) throws FileNotFoundException, IOException{
        try{
            File f = new File(fName);
            if(!f.exists()) return;
            
            
            FileReader fr = new FileReader(f);
            BufferedReader bf = new BufferedReader(fr);
            String code,name,priceStr;
            while((code= bf.readLine())!= null &&
                    (name = bf.readLine())!= null &&
                    (priceStr = bf.readLine())!= null)
            {
                storedCodes.add(code);
            }
            bf.close(); fr.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    private boolean valid(String acode)
    {
        int i;
        for(i =0 ; i < storedCodes.size();i++)
        {
            if(acode.equals(storedCodes.get(i))) return false;
        }
        for(i =0 ; i < storedCodes.size();i++)
        {
            if(acode.equals(this.get(i).getCode())) return false;
        }
        return true;
    }
    
    private int find(String acode)
    {
        int i;
        for(i =0 ; i < storedCodes.size();i++)
        {
            if(acode.equals(this.get(i).getCode())) return i;
        }
        return -1;
    }
    
    public void appendToFile (String fName) throws IOException
    {
        if(this.size()==0)
        {
           System.out.println("Empty list");
           return ;
        }
        try{
            boolean append = true;
            File f = new File(fName);
            FileWriter fw = new FileWriter(f,append);
            PrintWriter pw = new PrintWriter(fw);
            for(Item x:this)
            {
                pw.println(x.getCode());
                pw.println(x.getName());
                pw.println(x.getPrice());
                pw.flush();
            }
            pw.close(); fw.close(); 
            this.LoadStoredCode(fName);
            this.clear();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public void AddNewItem()
    {
        String code,name;
        int price;
        System.out.println("Enter new item details");
        boolean duplicated =false, matched = true;
        do
        {
            System.out.print(" code format I000 : ");
            code = sc.nextLine().toUpperCase();
            duplicated = !valid(code);
            matched = code.matches("^I\\d{3}$");
            if (duplicated) {System.out.println("The code is duplicated");
            }
            if(matched)
            {
                System.out.println("the code : I and 3 digits");
            }
        }while(duplicated ||(!matched));
        System.out.print("   name:");
        name= sc.nextLine();
        System.out.print("   price:");
        price = Integer.parseInt(sc.nextLine());
        this.add(new Item(code, name, price));
        System.out.println("New item had been added");
    }
}
