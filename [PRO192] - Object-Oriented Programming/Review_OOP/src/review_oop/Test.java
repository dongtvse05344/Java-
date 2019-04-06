/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package review_oop;

import java.util.Scanner;

/**
 *
 * @author xhunt
 */
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Caphe scl = new Caphe("Nau","DolaTrump");
        System.out.print("Enter Ma Hang : ");
        scl.MaHang = sc.nextLine();
        
        System.out.print("Enter Ten Hang : ");
        scl.TenHang = sc.nextLine();
        
        System.out.print("Enter Don Gia : ");
        scl.DonGia = Float.parseFloat(sc.nextLine()) ;
        
        System.out.print("Enter So luong : ");
        scl.SoLuong = Integer.parseInt(sc.nextLine()) ;
        
        scl.showInfo();
        System.out.print("Hoa don quy khach het : ");
        System.out.println(scl.ThanhTien()+ " " + scl.getDonViTinh());
    }
}
