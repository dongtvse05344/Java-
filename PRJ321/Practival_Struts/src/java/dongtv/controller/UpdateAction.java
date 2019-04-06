/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dongtv.controller;

import com.opensymphony.xwork2.ActionSupport;
import dongtv.dao.FlightDAO;
import dongtv.dto.FlightDTO;

/**
 *
 * @author xhunt
 */
public class UpdateAction extends ActionSupport{
    
    private String code,name,color,chairNo;
    private FlightDTO dto;

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

    public String getChairNo() {
        return chairNo;
    }

    public void setChairNo(String chairNo) {
        this.chairNo = chairNo;
    }

    public FlightDTO getDto() {
        return dto;
    }

    public void setDto(FlightDTO dto) {
        this.dto = dto;
    }
    
    @Override
    public void validate()
    {
        dto = new FlightDTO(code, name, color, 0);
        if(name.length() ==0)
        {
            addFieldError("name", "Name can not be blank");
        }
        if(!chairNo.matches("^[0-9]{1,}$"))
        {
            addFieldError("chairNo", "Chair number mus be a number");
        }
        else
        {
            dto.setChairNo(Integer.parseInt(chairNo));
        }
        if(color.length() ==0)
        {
            addFieldError("color", "Color can not be blank");
        }
    }
    
    public UpdateAction() {
    }
    
    public String execute() throws Exception {
        FlightDTO dto = new FlightDTO(code, name, color, Integer.parseInt(chairNo));
        FlightDAO dao = new FlightDAO();
        boolean check = dao.update(dto);
        if(check)
        {
            return "success";
        }else
        {
            return "failed";
        }
    }
    
}
