/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dongtv.dto;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author xhunt
 */
public class Fly_PlanDTO implements Serializable{
    private int id;
    private String FlightCode;
    private java.sql.Date DateFly;
    private int customerNo;

    public Fly_PlanDTO(int id, String FlightCode, Date DateFly, int customerNo) {
        this.id = id;
        this.FlightCode = FlightCode;
        this.DateFly = DateFly;
        this.customerNo = customerNo;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFlightCode() {
        return FlightCode;
    }

    public void setFlightCode(String FlightCode) {
        this.FlightCode = FlightCode;
    }

    public Date getDateFly() {
        return DateFly;
    }

    public void setDateFly(Date DateFly) {
        this.DateFly = DateFly;
    }

    public int getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(int customerNo) {
        this.customerNo = customerNo;
    }
    
}
