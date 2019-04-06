/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dongtv.dao;

import dongtv.dto.ContactDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xhunt
 */
public class ContactDAO implements Serializable {

    private Connection conn;
    private PreparedStatement preStm;
    private ResultSet rs;

    private void closeConnect() throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (preStm != null) {
            preStm.close();
        }
        if (conn != null) {
            conn.close();
        }
    }
    
    public boolean insert(ContactDTO dto) throws Exception
    {
        boolean check = false;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "INSERT INTO Contact(Fullname,Email,Phone,Message) VALUES(?,?,?,?) ";
            preStm = conn.prepareStatement(sql);
            preStm.setNString(1, dto.getFullname());
            preStm.setString(2, dto.getEmail());
            preStm.setString(3, dto.getPhone());
            preStm.setString(4, dto.getMessage());
            check = preStm.executeUpdate() > 0;
        }finally {
            closeConnect();
        }
        return check;
    }
    
    public List<ContactDTO> getAll() throws Exception
    {
        List<ContactDTO> result = new ArrayList<>();
        try {
            conn = MyConnection.getMyConnection();
            String sql = "SELECT Id,Fullname,Phone FROM Contact ";
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            while(rs.next())
            {
                result.add(new ContactDTO(rs.getInt("id"), rs.getString("Fullname"), null, rs.getString("Phone"), null));
            }
        } finally{
        }
        return result;
    }
    
    public ContactDTO get(int id) throws Exception
    {
        ContactDTO dto = null;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "SELECT Fullname,Phone,Email,Message FROM Contact WHERE Id = ? ";
            preStm =  conn.prepareStatement(sql);
            preStm.setInt(1, id);
            rs = preStm.executeQuery();
            if(rs.next())
            {
                dto = new ContactDTO(id, 
                        rs.getString("Fullname"),
                        rs.getString("Email") , 
                        rs.getString("Phone"), 
                        rs.getString("Message"));
            }
        }finally {
            closeConnect();
        }
        return dto;
    }
    
    public boolean delete(int id) throws Exception
    {
        boolean check = false;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Delete FROM Contact WHERE Id = ? ";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, id);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnect();
        }
        return check;
    }

}
