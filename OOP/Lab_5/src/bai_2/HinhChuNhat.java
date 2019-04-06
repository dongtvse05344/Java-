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
public class HinhChuNhat extends HinhHoc{
    private float width;
    private float height;

    public HinhChuNhat() {
    }

    public HinhChuNhat(float width, float height) {
        this.width = width;
        this.height = height;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }
    
    public void tinhCV()
    {
        chuVi = 2*(width+height);
    }
    
    public void tinhDT()
    {
        dienTich = width*height;
    }
    
}
