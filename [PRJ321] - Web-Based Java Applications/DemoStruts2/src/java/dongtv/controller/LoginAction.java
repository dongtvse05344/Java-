/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dongtv.controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import dongtv.dao.RegistrationDAO;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author xhunt
 */
public class LoginAction extends ActionSupport{
    private static final String ADMIN = "admin";
    private static final String USER = "user";
    private static final String FAIL = "error";
    
    private String username,password;

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
    
    
    public LoginAction() {
    }
    
    @Override
    public void validate()
    {
        if(username.length()==0)
        {
            addFieldError("username", "Username can not be blank");
        }
    }
    
    public String execute() throws Exception {
        RegistrationDAO dao = new RegistrationDAO();
        String role = dao.checkLogin(username, password);
        HttpServletRequest request = ServletActionContext.getRequest();
        String url = FAIL;
        if(role.equals("failed"))
        {
            request.setAttribute("ERROR", "Invalid username or password");
        }
        else{
            Map session = ActionContext.getContext().getSession();
            session.put("USER",username);
            if(role.equals("admin"))
            {
                url = ADMIN;
            }
            else if(role.equals("user"))
            {
                url = USER;
            }
            else{
                request.setAttribute("ERROR", "Your role is invalid");
            }
        }
        return url;
    }
    
}
