/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import account.Account;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

/**
 *
 * @author xhunt
 */
public class Bank {
    int lastAccountNumber;
    Account account[];
    Scanner sc = new Scanner(System.in);
    File f = new File("AccountManagement.dat");
    public Bank() throws FileNotFoundException, IOException, ClassNotFoundException
    {
        account = new Account[10];
        lastAccountNumber = 0;
        if(f.exists())
        {
            try{
                FileInputStream fis = new FileInputStream(f);
                ObjectInputStream ois = new ObjectInputStream(fis);
                while(fis.available()>0)
                {
                    account[lastAccountNumber++]= (Account)ois.readObject();
                }
                ois.close();
                fis.close();
            }
            catch( Exception e)
            {
                System.out.println("Exeption occured - " +e.getMessage());
            }
        }
    }
    
    public void createAccount(Account objAccount)
    {
        account[lastAccountNumber-1] = objAccount;
    }
    
    public void withdraw()
    {
        int accNum = 0, amount =0;
        //Nhap va kiem tra account number
        do
        {
            System.out.println("Enter the account number :");
            accNum = Integer.parseInt(sc.nextLine()) ;
            if( accNum <= 0 || accNum > lastAccountNumber)
                System.out.println("The account number is not valid");
        } while(accNum <=0 || accNum > lastAccountNumber );
        do
        {
            System.out.println("Enter the amount you wish to withdaw :");
            amount = Integer.parseInt(sc.nextLine()) ;
            if(amount < 100)
            {
                System.out.println("The amount must be greater than 100");
            }
        } while(amount <100);
        if(account[accNum-1].Balance -amount <500)
        {
            System.out.println("The standard account must have minimum 500 in balance");
        }
        else
        {
            account[accNum -1].Balance -= amount;
            System.out.println("Withdaw success ...");
            System.out.println("Account Number :" + accNum);
            System.out.println("Account balance ; "+ account[accNum-1].Balance);
        }
    }
    
    public void deposit()
    {
        int accNum = 0 , amount =0 ;
        do
        {
            System.out.println("Enter the account number");
            accNum = Integer.parseInt(sc.nextLine()) ;
            if( accNum <= 0 || accNum > lastAccountNumber)
                System.out.println("The account number is not valid");
        } while(accNum <=0 || accNum > lastAccountNumber );
        do
        {
            System.out.println("Enter the amount you wish to deposit: ");
            amount = Integer.parseInt(sc.nextLine()) ;
            if(amount < 100)
            {
                System.out.println("The amount must be greater than 100");
            }
        }while(amount <100);
        account[accNum -1].Balance += amount;
        System.out.println("Deposit success ...");
        System.out.println("Account Number :" + accNum);
        System.out.println("Account balance ; "+ account[accNum-1].Balance);
    }
    
    public void display()
    {
        int accNum = 0 , amount =0 ;
        do
        {
            System.out.println("Enter the account number");
            accNum = Integer.parseInt(sc.nextLine()) ;
            if( accNum <= 0 || accNum > lastAccountNumber)
                System.out.println("The account number is not valid");
        } while(accNum <=0 || accNum > lastAccountNumber );
        
        System.out.println("Account detail: ...");
        System.out.println("Account Number :" + accNum);
        System.out.println("Account balance ; "+ account[accNum-1].Balance);
    }
    
}
