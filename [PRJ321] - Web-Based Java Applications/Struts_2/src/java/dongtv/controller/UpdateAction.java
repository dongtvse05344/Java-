/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dongtv.controller;

import com.opensymphony.xwork2.ActionSupport;
import dongtv.dao.LaptopDAO;
import dongtv.dto.LaptopDTO;

/**
 *
 * @author xhunt
 */
public class UpdateAction extends ActionSupport{
    
    private String laptopName,price,publisher,laptopCode,searchPub;
    private LaptopDTO dto;

    public LaptopDTO getDto() {
        return dto;
    }

    public void setDto(LaptopDTO dto) {
        this.dto = dto;
    }
    
    

    public String getSearchPub() {
        return searchPub;
    }

    public void setSearchPub(String searchPub) {
        this.searchPub = searchPub;
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
    
    
    
    public UpdateAction() {
    }
    
    @Override
    public void validate()
    {
        dto = new LaptopDTO(laptopCode, laptopName, 0, publisher);
        if(laptopName.length() ==0) 
        {
            addFieldError("laptopName", "Name can not be blank");
        }
        if(!price.matches("^[0-9.]{1,}$"))
        {
            addFieldError("price", "Price must be a digit");
        }
        else
        {
            dto.setPrice(Float.parseFloat(price));
        }
        if(publisher.length() ==0) 
        {
            addFieldError("publisher", "Publisher can not be blank");
        }
    }
    
    public String execute() throws Exception {
        LaptopDAO dao = new LaptopDAO();
        boolean check = dao.update(new LaptopDTO(laptopCode, laptopName, Float.parseFloat(price), publisher));
        if(check)
        {
            return "success";
        }
        else
        {
            return "failed";
        }
    }
    
}
