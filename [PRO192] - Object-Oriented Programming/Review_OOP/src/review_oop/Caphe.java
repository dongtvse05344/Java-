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
public class Caphe extends MatHang implements IMatHang{
    private String MauSac;
    private String DonViTinh;

    public Caphe() {
    }

    public Caphe(String MauSac, String DonViTinh) {
        this.MauSac = MauSac;
        this.DonViTinh = DonViTinh;
    }

    public String getMauSac() {
        return MauSac;
    }

    public void setMauSac(String MauSac) {
        this.MauSac = MauSac;
    }

    public String getDonViTinh() {
        return DonViTinh;
    }

    public void setDonViTinh(String DonViTinh) {
        this.DonViTinh = DonViTinh;
    }
    
    @Override
    public float ThanhTien() {
        return SoLuong * DonGia;
    }

    @Override
    public void showInfo() {
        System.out.println("MA :" + MaHang +" , Name : " +TenHang  );
        System.out.println("Mau sac : "+ MauSac + " , Don vi tinh " + DonViTinh);
        System.out.println("Don gia " + DonGia + " , So luong : " + SoLuong);
    }
    
}
