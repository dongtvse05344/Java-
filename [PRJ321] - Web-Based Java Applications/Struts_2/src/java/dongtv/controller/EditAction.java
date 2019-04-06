/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dongtv.controller;

import dongtv.dao.LaptopDAO;
import dongtv.dto.LaptopDTO;

/**
 *
 * @author xhunt
 */
public class EditAction {
    private String laptopCode,searchPub; // nhan len
    private LaptopDTO dto; // tra ve
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

    public LaptopDTO getDto() {
        return dto;
    }

    public void setDto(LaptopDTO dto) {
        this.dto = dto;
    }
    
    
    public EditAction() {
    }
    
    public String execute() throws Exception {
        LaptopDAO dao = new LaptopDAO();
        dto = dao.get(laptopCode);
        return "success";
    }
    
}
