/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dongtv.dao;

import dongtv.dto.RegistrationDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author linh
 */
public class RegistrationDAO implements Serializable{
    private Connection conn ;
    private PreparedStatement preStm;
    private ResultSet rs;
    private void closeConnection() throws Exception
    {
        if(rs != null) rs.close();
        if(preStm != null) preStm.close();
        if(conn != null) conn.close();
    }
    
    public  String checkLogin(String username,String password) throws Exception
    {
        String role= "failed";
        try {
            conn = MyConnection.getMyconnection();
            String sql = "SELECT Role FROM Registrations WHERE Username = ? AND Password =  ? ";
            preStm =conn.prepareStatement(sql);
            preStm.setString(1, username);
            preStm.setString(2, password);
            rs =preStm.executeQuery();
            if(rs.next())
            {
                role = rs.getString("Role");
            }
        } finally {
            closeConnection();
        }
        return role;
    }
    
    public List<RegistrationDTO> search(String search) throws Exception
    {
        List<RegistrationDTO> result = new LinkedList<>();
        try {
            conn = MyConnection.getMyconnection();
            String sql ="SELECT Username, Name, Role FROM Registrations WHERE Name LIKE ? ";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%"+search +"%");
            rs = preStm.executeQuery();
            while(rs.next())
            {
                result.add(new RegistrationDTO(rs.getString("Username"),
                                                null,
                                                rs.getString("Name"),
                                                rs.getString("Role")));
            }
        } finally {
            closeConnection();
        }
        System.out.println(result.size());
        return result;
    }
    
    public RegistrationDTO get(String id) throws Exception
    {
        RegistrationDTO res = null;
        try {
            conn = MyConnection.getMyconnection();
            String sql ="SELECT Name, Role FROM Registrations WHERE Username = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, id);
            rs = preStm.executeQuery();
            if(rs.next())
            {
                String fullname = rs.getString("Name");
                String role = rs.getString("Role");
                res = new RegistrationDTO(id, "", fullname, role);
            }
        } finally {
            closeConnection();
        }
        return res;
    }
    
    public boolean update(RegistrationDTO dto) throws Exception
    {
        boolean res = false;
        try {
            conn = MyConnection.getMyconnection();
            String sql = "UPDATE Registrations SET Password = ? , Name = ?, Role = ? WHERE Username = ? ";
            preStm = conn.prepareStatement(sql);
            preStm.setString(4, dto.getUsername());
            preStm.setString(1, dto.getPassword());
            preStm.setString(2, dto.getFullname());
            preStm.setString(3, dto.getRole());
            res = preStm.executeUpdate() > 0;
        } finally {
        }
        return res;
    }
    
    public boolean create(RegistrationDTO dto) throws Exception
    {
        boolean res = false;
        try {
            conn = MyConnection.getMyconnection();
            String sql = "INSERT INTO Registrations(Username,Password,Name,Role) VALUES(?,?,?,?)";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getUsername());
            preStm.setString(2, dto.getPassword());
            preStm.setString(3, dto.getFullname());
            preStm.setString(4, dto.getRole());
            res = preStm.executeUpdate() > 0;
        } finally {
        }
        return res;
    }
    
}
