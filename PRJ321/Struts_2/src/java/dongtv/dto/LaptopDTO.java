/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dongtv.dto;

import java.io.Serializable;

/**
 *
 * @author xhunt
 */
public class LaptopDTO implements Serializable{
    private String laptopCode, laptopName;
    private float price;
    private String publisher;

    public LaptopDTO(String laptopCode, String laptopName, float price, String publisher) {
        this.laptopCode = laptopCode;
        this.laptopName = laptopName;
        this.price = price;
        this.publisher = publisher;
    }

    public String getLaptopCode() {
        return laptopCode;
    }

    public void setLaptopCode(String laptopCode) {
        this.laptopCode = laptopCode;
    }

    public String getLaptopName() {
        return laptopName;
    }

    public void setLaptopName(String laptopName) {
        this.laptopName = laptopName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    
}
