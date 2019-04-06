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
public class HinhTron extends HinhHoc{
    
    private float banKinh ;

    public HinhTron() {
    }

    public HinhTron(float banKinh) {
        this.banKinh = banKinh;
    }

    public float getBanKinh() {
        return banKinh;
    }

    public void setBanKinh(float banKinh) {
        this.banKinh = banKinh;
    }
    
    public void tinhCV()
    {
        chuVi = (float) (2*Math.PI*banKinh);
    }
    
    public void tinhDT()
    {
        dienTich = (float) (banKinh*banKinh*Math.PI);
    }
    
}
