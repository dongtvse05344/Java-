/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package review_oop;

/**
 *
 * @author xhunt
 */
public abstract class MatHang {
    protected String MaHang;
    protected String TenHang;
    protected float DonGia;
    protected int SoLuong;

    public String getMaHang() {
        return MaHang;
    }

    public void setMaHang(String MaHang) {
        this.MaHang = MaHang;
    }

    public String getTenHang() {
        return TenHang;
    }

    public void setTenHang(String TenHang) {
        this.TenHang = TenHang;
    }

    public float getDonGIa() {
        return DonGia;
    }

    public void setDonGIa(float DonGIa) {
        this.DonGia = DonGIa;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }
    
    public abstract float ThanhTien();
}
