/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dongtv.model;

import dongtv.DTOs.RegistrationDTO;
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
public class RegistrationsDAO implements Serializable {

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
    
    public String checkLogin(String username,String password) throws SQLException, ClassNotFoundException
    {
        String role = "failed";
        try {
            conn = DbUtil.getMyConnection();
            String sql = "SELECT Role FROM Registrations WHERE Username = ? AND Password = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            preStm.setString(2, password);
            rs = preStm.executeQuery();
            if(rs.next())
            {
                role = rs.getString("Role");
            }
        } finally {
            closeConnect();
        }
        return role;
    }

    public List<RegistrationDTO> getAll() throws SQLException, ClassNotFoundException {
        List<RegistrationDTO> result = new ArrayList<>();
        try {
            conn = DbUtil.getMyConnection();
            String sql = "SELECT Username,Password,Name,Role FROM Registrations ORDER BY role";
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            while (rs.next()) {
                result.add(new RegistrationDTO(rs.getString("Username"),
                                                rs.getString("Password"),
                                                rs.getString("Name"),
                                                rs.getString("Role")));
            }
        } finally {
            closeConnect();
        }
        return result;
    }
    
    

    public List<RegistrationDTO> search(String nameSearch) throws ClassNotFoundException, SQLException {
        List<RegistrationDTO> result = new ArrayList<>();
        try {
            conn = DbUtil.getMyConnection();
            String sql = "SELECT Username,Password,Name,Role FROM Registrations WHERE name LIKE ?  ORDER BY Role";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%"+nameSearch+"%");
            rs = preStm.executeQuery();
            while (rs.next()) {
                result.add(new RegistrationDTO(rs.getString("Username"),
                        rs.getString("Password"),
                        rs.getString("Name"),
                        rs.getString("Role")));
            }
        } finally {
            closeConnect();
        }
        return result;
    }
    
    public RegistrationDTO get(String id) throws ClassNotFoundException, SQLException
    {
        RegistrationDTO result = null;
        try {
            conn = DbUtil.getMyConnection();
            String sql = "SELECT Username,Password,Name,Role FROM Registrations WHERE Username = ? ";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, id);
            rs = preStm.executeQuery();
            while (rs.next()) {
                result =new RegistrationDTO(rs.getString("Username"),
                        rs.getString("Password"),
                        rs.getString("Name"),
                        rs.getString("Role"));
            }
        } finally {
            closeConnect();
        }
        return result;
    }
    
    public boolean insert(RegistrationDTO dto) throws ClassNotFoundException, SQLException
    {
        boolean result = false;
        try {
            conn = DbUtil.getMyConnection();
            String sql = "INSERT INTO Registrations(Username,Password,Name,Role) VALUES(?,?,?,?)";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getUsername());
            preStm.setString(2, dto.getPassword());
            preStm.setString(3, dto.getName());
            preStm.setString(4, dto.getRole());
            result = preStm.executeUpdate()> 0;
        } finally {
            closeConnect();
        }
        return result;
    }
    
    public boolean update(RegistrationDTO dto) throws ClassNotFoundException, SQLException
    {
        boolean result = false;
        try {
            conn = DbUtil.getMyConnection();
            String sql = "UPDATE Registrations SET Password = ? , Name = ?, Role = ? WHERE Username = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(4, dto.getUsername());
            preStm.setString(1, dto.getPassword());
            preStm.setString(2, dto.getName());
            preStm.setString(3, dto.getRole());
            result = preStm.executeUpdate()> 0;
        } finally {
            closeConnect();
        }
        return result;
    }
    
    public boolean delete(String code) throws ClassNotFoundException, SQLException
    {
        boolean result = false;
        try {
            conn = DbUtil.getMyConnection();
            String sql = "DELETE FROM Registrations WHERE Username = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, code);
            result = preStm.executeUpdate()> 0;
        } finally {
            closeConnect();
        }
        return result;
    }

}
