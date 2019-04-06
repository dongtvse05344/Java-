/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai_2;

/**
 *
 * @author xhunt
 */
public class Test {
    public static void main(String[] args) {
        HinhChuNhat hcn = new HinhChuNhat(5,6);
        hcn.tinhCV();
        System.out.println("Chu vi :" + hcn.chuVi);
        hcn.tinhDT();
        System.out.println("Dien tich :" + hcn.dienTich);
    }
   
}
