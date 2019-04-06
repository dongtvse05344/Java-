/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dongtv.controller;

import dongtv.dao.LaptopDAO;

/**
 *
 * @author xhunt
 */
public class DeleteAction {
    
    private String laptopCode ;
    
    public DeleteAction() {
    }

    public String getLaptopCode() {
        return laptopCode;
    }

    public void setLaptopCode(String laptopCode) {
        this.laptopCode = laptopCode;
    }
    
    public String execute() throws Exception {
        LaptopDAO dao = new LaptopDAO();
        dao.delete(laptopCode);
        return "success";
    }
    
}
