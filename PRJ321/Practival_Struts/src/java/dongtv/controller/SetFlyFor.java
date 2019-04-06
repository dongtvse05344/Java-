/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dongtv.controller;

import dongtv.dao.FlightDAO;
import dongtv.dto.FlightDTO;

/**
 *
 * @author xhunt
 */
public class SetFlyFor {
    
    
    private  String flightCode;
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
    
    public SetFlyFor() {
    }
    
    public String execute() throws Exception {
        FlightDAO dao = new FlightDAO();
        dto = dao.get(flightCode);
        return "success";
    }
    
}
