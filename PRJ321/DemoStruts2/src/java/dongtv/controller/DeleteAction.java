/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dongtv.controller;

import dongtv.dao.QuestionBankDAO;

/**
 *
 * @author xhunt
 */
public class DeleteAction {
    private String id,lastSearchValue;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastSearchValue() {
        return lastSearchValue;
    }

    public void setLastSearchValue(String lastSearchValue) {
        this.lastSearchValue = lastSearchValue;
    }
    
    
    public DeleteAction() {
    }
    
    public String execute() throws Exception {
        QuestionBankDAO dao = new QuestionBankDAO();
        boolean check = dao.delete(Integer.parseInt(id));
        if(check) return "success";
        else
            return "failed";
    }
    
}
