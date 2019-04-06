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
public class FlightDTO implements Serializable{
    private String code,name,color;
    private int chairNo;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getChairNo() {
        return chairNo;
    }

    public void setChairNo(int chairNo) {
        this.chairNo = chairNo;
    }

    public FlightDTO(String code, String name, String color, int chairNo) {
        this.code = code;
        this.name = name;
        this.color = color;
        this.chairNo = chairNo;
    }
    
    
}
