/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dongtv.controller;

import dongtv.dao.FlightDAO;

/**
 *
 * @author xhunt
 */
public class DeleteAction {
    
    private String searchName,code;

    public String getSearchName() {
        return searchName;
    }

    public void setSearchName(String searchName) {
        this.searchName = searchName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
    public DeleteAction() {
    }
    
    public String execute() throws Exception {
        FlightDAO dao = new FlightDAO();
        boolean check = dao.delete(code);
        return "success";
    }
    
}
