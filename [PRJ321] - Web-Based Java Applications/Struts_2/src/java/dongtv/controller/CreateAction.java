package dongtv.controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import dongtv.dao.LaptopDAO;
import dongtv.dto.LaptopDTO;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author xhunt
 */
public class CreateAction extends ActionSupport{
    
    private String laptopCode,laptopName,price, publisher;

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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    
    
    @Override
    public void validate()
    {
        if(laptopCode.length() == 0)
        {
            addFieldError("laptopCode", "Code can not be blank");
        }
        
        if(laptopName.length() == 0)
        {
            addFieldError("laptopName", "Name can not be blank");
        }
    }
    
    public CreateAction() {
    }
    
    public String execute() throws Exception {
        LaptopDAO dao = new LaptopDAO();
        dao.create(new LaptopDTO(laptopCode, laptopName, Float.parseFloat(price), publisher));
        return "success";
    }
    
}
