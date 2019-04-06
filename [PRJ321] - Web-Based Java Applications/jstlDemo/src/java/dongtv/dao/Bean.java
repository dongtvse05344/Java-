/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dongtv.dao;

import dongtv.dto.RegistrationDTO;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author linh
 */
public class Bean implements Serializable{
    private String username, password,searchValue;
    private List<RegistrationDTO> listUser;
    private RegistrationDTO dto;

    public RegistrationDTO getDto() {
        return dto;
    }

    public void setDto(RegistrationDTO dto) {
        this.dto = dto;
    }
    
    public boolean create() throws Exception
    {
        RegistrationDAO dao = new RegistrationDAO();
        return dao.create(dto);
    }
    
    public boolean update() throws Exception
    {
        RegistrationDAO dao = new RegistrationDAO();
        return dao.update(dto);
    }
    
    public void get() throws Exception
    {
        RegistrationDAO dao = new RegistrationDAO();
        dto = dao.get(username);
    }

    public List<RegistrationDTO> getListUser() {
        return listUser;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }
    
    public void findByLikeFullname() throws Exception{
        RegistrationDAO dao = new RegistrationDAO();
        listUser = dao.search(searchValue);
    }
    public Bean() {
    }

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
    public String checkLogin() throws Exception
    {
        RegistrationDAO dao = new RegistrationDAO();
        return dao.checkLogin(username, password);
    }
}
