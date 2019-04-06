/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai_1;

/**
 *
 * @author xhunt
 */
public class Test {
    public static void main(String[] args) {
        HinhChuNhat hcn = new HinhChuNhat(5,6);
        hcn.showInfo();
        System.out.println("Chu vi :" + hcn.Chuvi());
        System.out.println("Dien tich :" + hcn.Dientich());
    }
}
