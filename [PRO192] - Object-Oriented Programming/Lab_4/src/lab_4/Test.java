/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_4;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author xhunt
 */
public class Test {
    SinhVien[] DsSv =new SinhVien[50] ;
    int i =0;
    int choice(){
        System.out.println("1 - Xem danh sach sinh vien");
        System.out.println("2 - Them sinh vien");
        System.out.println("3 - Tim sinh vien");
        System.out.println("4 - Cap nhat thong tin sinh vien");
        Scanner sc = new Scanner(System.in);
        int c ;
        c = sc.nextInt();
        return c;
    }
    
    void GetListAll(){
        for(int j = 0; j<i;j++)
        {
            DsSv[j].XemThongTin();
        }
    }
    
    void Set(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Ma SV : ");
        String masv = sc.nextLine();
        System.out.print("Enter Ho ten SV : ");
        String Hoten = sc.nextLine();
        System.out.print("Enter ngay sinh SV : ");
        String d = sc.nextLine();
        System.out.print("Enter dia chi SV : ");
        String DiaChi = sc.nextLine();
        System.out.print("Enter dien thoai SV : ");
        String DienThoai = sc.nextLine();
        int j,f = 0;
        for( j = 0; j< i ; j++)
        {
            if(masv.equals(DsSv[j].getMaSV()))
            {
                f = 1;
                break;
            }
        }
        if(f ==1)
        {
            System.out.println("Code sv existed !");
        }
        else
        {
           DsSv[i++] = new SinhVien(masv,Hoten,d,DiaChi,DienThoai);
            System.out.println("Add success");
        }
    }
    void Find(){
        String s;
        System.out.print("Enter ten sv :");
        Scanner sc = new Scanner(System.in);
        s = sc.nextLine();
        for(int j = 0; j<i;j++)
        {
            if(s.equals(DsSv[j].getHoten()) )
            {
                DsSv[j].XemThongTin();
            }
        }
    }
    
    public void Update(){
        System.out.print("Enter Code SV : ");
        String c ;
        Scanner sc = new Scanner(System.in);
        c = sc.nextLine();
        int j,f = 0;
        for( j = 0; j< i ; j++)
        {
            if(c.equals(DsSv[j].getMaSV()))
            {
                f = 1;
                break;
            }
        }
        if (f ==1 )
        {
            String masv = c;
            System.out.print("Enter Ho ten SV : ");
            String Hoten = sc.nextLine();
            System.out.print("Enter ngay sinh SV : ");
            String d = sc.nextLine();
            System.out.print("Enter dia chi SV : ");
            String DiaChi = sc.nextLine();
            System.out.print("Enter dien thoai SV : ");
            String DienThoai = sc.nextLine();
            DsSv[j] = new SinhVien(masv,Hoten,d,DiaChi,DienThoai);
            System.out.println("Update data success !");
        }
        else {
            System.out.println("Not found !");
        }
    }
    
    public static void main(String[] args) {
        
        Test test = new Test();
        int c;
        do
        {
            c = test.choice();
            switch(c)
            {
                case 1 : test.GetListAll(); break;
                case 2 : test.Set(); break;
                case 3 : test.Find(); break;
                case 4 : test.Update(); break;
                default : c =  -1;
            }
        }
        while (c != -1);
    }
}
