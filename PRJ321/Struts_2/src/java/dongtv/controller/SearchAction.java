/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dongtv.controller;

import dongtv.dao.LaptopDAO;
import dongtv.dto.LaptopDTO;
import java.util.List;

/**
 *
 * @author xhunt
 */
public class SearchAction {
    
    private String searchPub;
    private List<LaptopDTO> list;

    public String getSearchPub() {
        return searchPub;
    }

    public void setSearchPub(String searchPub) {
        this.searchPub = searchPub;
    }

    public List<LaptopDTO> getList() {
        return list;
    }
    
    
    public SearchAction() {
    }
    
    public String execute() throws Exception {
        LaptopDAO dao = new LaptopDAO();
        list = dao.search(searchPub);
        return "success";
    }
    
}
