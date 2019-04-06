/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dongtv.controller;

import com.opensymphony.xwork2.ActionSupport;
import dongtv.dao.FlightDAO;
import dongtv.dao.Fly_PlanDAO;
import dongtv.dto.FlightDTO;
import dongtv.dto.Fly_PlanDTO;
import java.sql.Date;

/**
 *
 * @author xhunt
 */
public class InsertFlyAction extends ActionSupport{
    
    private String flightCode,dateFly,customerNo,chairNo;
    private FlightDTO dto ;

    public FlightDTO getDto() {
        return dto;
    }

    public void setDto(FlightDTO dto) {
        this.dto = dto;
    }
    
    

    public String getFlightCode() {
        return flightCode;
    }

    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
    }

    public String getDateFly() {
        return dateFly;
    }

    public void setDateFly(String dateFly) {
        this.dateFly = dateFly;
    }

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    public String getChairNo() {
        return chairNo;
    }

    public void setChairNo(String chairNo) {
        this.chairNo = chairNo;
    }
    
    
    
    public InsertFlyAction() {
    }
    
    @Override
    public void validate()
    {
        FlightDAO dao = new FlightDAO();
        try {
            dto = dao.get(flightCode);
        } catch (Exception e) {
        }
        if(!customerNo.matches("^[0-9]{1,}$"))
        {
            addFieldError("customerNo", "Customer number must be a digit");
        }
        
        if(!dateFly.matches("^[0-9]{2}-[0-9]{2}-[0-9]{4}$"))
        {
            addFieldError("dateFly", "Date must be like format dd-mm-yyyy");
        }
    }
    public String execute() throws Exception {
        Fly_PlanDAO dao = new Fly_PlanDAO();
        String[] temp = dateFly.split("-");
        int day = Integer.parseInt(temp[0]);
        int month = Integer.parseInt(temp[1]);
        int year = Integer.parseInt(temp[2]);
        boolean check = dao.insert(new Fly_PlanDTO(0, flightCode, new Date(year-1900, month-1, day), Integer.parseInt(customerNo)));
        if(check )
        {
            return "success";
        }
        else
        {
            return "failed";
        }
    }
    
}
