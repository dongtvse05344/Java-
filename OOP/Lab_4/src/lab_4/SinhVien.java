/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_4;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author xhunt
 */
public class SinhVien {
    private String MaSV;
    private String Hoten;
    private Date NgaySinh =  new Date();
    private String Diachi;
    private String DienThoai;

    public SinhVien()
    {
        
    }
    public SinhVien(String MaSV, String Hoten, String str, String Diachi, String DienThoai) {
        this.MaSV = MaSV;
        this.Hoten = Hoten;
        this.Diachi = Diachi;
        this.DienThoai = DienThoai;
        this.NgaySinh = new Date(str);
    }

    public String getMaSV() {
        return MaSV;
    }

    public String getHoten() {
        return Hoten;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public String getDiachi() {
        return Diachi;
    }

    public String getDienThoai() {
        return DienThoai;
    }

    public void setMaSV(String MaSV) {
        this.MaSV = MaSV;
    }

    public void setHoten(String Hoten) {
        this.Hoten = Hoten;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public void setDiachi(String Diachi) {
        this.Diachi = Diachi;
    }

    public void setDienThoai(String DienThoai) {
        this.DienThoai = DienThoai;
    }
    
    public void XemThongTin(){
        System.out.println("Ma Sinh Vien :" + MaSV);
        System.out.println("Ho va Ten :" + Hoten);
        System.out.println("Ngay Sinh :" + NgaySinh);
        System.out.println("Dia chi :" + Diachi);
        System.out.println("Dien thoai :" + DienThoai);
    }
    
}
