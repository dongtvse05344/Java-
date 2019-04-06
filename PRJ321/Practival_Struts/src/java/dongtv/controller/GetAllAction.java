/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dongtv.controller;

import dongtv.dao.FlightDAO;
import dongtv.dto.FlightDTO;
import java.util.List;

/**
 *
 * @author xhunt
 */
public class GetAllAction {
    
    private List<FlightDTO> list;

    public List<FlightDTO> getList() {
        return list;
    }

    public void setList(List<FlightDTO> list) {
        this.list = list;
    }
    
    
    public GetAllAction() {
    }
    
    public String execute() throws Exception {
        FlightDAO dao = new FlightDAO();
        list = dao.getAll();
        return "success";
    }
    
}
