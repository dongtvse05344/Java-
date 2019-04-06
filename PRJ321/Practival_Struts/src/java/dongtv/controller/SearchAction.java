/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dongtv.controller;

import com.opensymphony.xwork2.ActionSupport;
import dongtv.dao.FlightDAO;
import dongtv.dto.FlightDTO;
import java.util.List;

/**
 *
 * @author xhunt
 */
public class SearchAction extends ActionSupport{
    
    private String searchName,errorMess;

    public String getErrorMess() {
        return errorMess;
    }

    public void setErrorMess(String errorMess) {
        this.errorMess = errorMess;
    }
    private List<FlightDTO> list;

    public String getSearchName() {
        return searchName;
    }

    public void setSearchName(String searchName) {
        this.searchName = searchName;
    }

    public List<FlightDTO> getList() {
        return list;
    }

    public void setList(List<FlightDTO> list) {
        this.list = list;
    }

    
    public SearchAction() {
    }
    
    @Override
    public void validate()
    {
        if(searchName.length()==0)
        {
            addFieldError("searchName", "Name search can not be blank");
        }
    }
    
    public String execute() throws Exception {
        FlightDAO dao = new FlightDAO();
        list = dao.search(searchName);
        return "success";
    }
    
}
