/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dongtv.controller;

import com.opensymphony.xwork2.ActionSupport;
import dongtv.dao.QuestionBankDAO;
import dongtv.dto.QuestionBankDTO;
import java.util.List;

/**
 *
 * @author xhunt
 */
public class SearchAction extends ActionSupport {
    
    
    private String txtSearch ;
    private List<QuestionBankDTO> listQues;

    public List<QuestionBankDTO> getListQues() {
        return listQues;
    }
    
    

    public String getTxtSearch() {
        return txtSearch;
    }

    public void setTxtSearch(String txtSearch) {
        this.txtSearch = txtSearch;
    }
    
    @Override
    public void validate()
    {
        if(txtSearch.length() ==0)
        {
            addFieldError("txtSearch", "Name Search can not be blank");
        }
    }
    
    public SearchAction() {
    }
    
    public String execute() throws Exception {
        QuestionBankDAO dao =  new QuestionBankDAO();
        listQues = dao.search(txtSearch);
        return "success";
    }
    
}
