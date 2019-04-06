/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dongtv.controller;

import com.opensymphony.xwork2.ActionSupport;
import dongtv.dao.RegistrationDAO;
import dongtv.dto.RegistrationDTO;

/**
 *
 * @author xhunt
 */
public class InsertAction extends ActionSupport {

    private String username, password, confirm, emailID, phoneNo;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public InsertAction() {
    }

    public String execute() throws Exception {
        RegistrationDAO dao = new RegistrationDAO();
        boolean check = dao.create(new RegistrationDTO(username, password, "user", emailID));
        if (check) {
            return SUCCESS;

        } else {
            return "failed";
        }
    }

}
