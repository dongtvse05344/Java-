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
public class HinhChuNhat implements IHinh {
    private float width;
    private float height;

    public HinhChuNhat(float width, float height) {
        this.width = width;
        this.height = height;
    }

    public HinhChuNhat() {
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
    
    @Override
    
    public float Chuvi() {
        return 2*(width + height);
    }

    @Override
    public float Dientich() {
        return width*height;
    }

    @Override
    public void showInfo() {
        System.out.println("Width : "+ width + ", Height :" +height);
    }
    
}
