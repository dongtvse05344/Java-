/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dongtv.dao;

import dongtv.conn.MyConnection;
import dongtv.dto.LaptopDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xhunt
 */
public class LaptopDAO implements Serializable{
    Connection conn = null;
    PreparedStatement preStm = null;
    ResultSet rs = null;

   
    private void closeConnect() throws Exception {
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
    
    public boolean create(LaptopDTO dto ) throws Exception
    {
        boolean check = false;
        try {
            conn = MyConnection.getConnection();
            String sql= "INSERT INTO tbl_Laptop(LaptopCode,LaptopName,Price,Publisher) VALUES(?,?,?,?)";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getLaptopCode());
            preStm.setString(2, dto.getLaptopName());
            preStm.setFloat(3, dto.getPrice());
            preStm.setString(4, dto.getPublisher());
            check = preStm.executeUpdate()> 0;
        } finally {
            closeConnect();
        }
        return check;
    }
    
    public List<LaptopDTO> search(String pubisherSearch) throws Exception
    {
        
        List<LaptopDTO> result = new ArrayList<>();
        try {
            conn = MyConnection.getConnection();
            String sql = "SELECT LaptopCode,LaptopName,Price FROM tbl_Laptop WHERE Publisher = ? ";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, pubisherSearch);
            rs = preStm.executeQuery();
            while(rs.next())
            {
                result.add(new LaptopDTO(rs.getString("LaptopCode"),
                        rs.getString("LaptopName"), 
                        rs.getInt("Price"),
                        pubisherSearch));
            }
        }
        finally {
            closeConnect();
        }
        return result;
    }
    
    public LaptopDTO get(String LaptopCode) throws Exception
    {
        LaptopDTO result = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "SELECT LaptopName,Price,Publisher FROM tbl_Laptop WHERE LaptopCode = ? ";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, LaptopCode);
            rs = preStm.executeQuery();
            while(rs.next())
            {
                result = new LaptopDTO(LaptopCode,
                        rs.getString("LaptopName"), 
                        rs.getInt("Price"),
                        rs.getString("Publisher"));
            }
        } finally {
            closeConnect();
        }
        return result;
    }
    
    public boolean update(LaptopDTO dto) throws Exception
    {
        boolean check = false;
        try {
            conn = MyConnection.getConnection();
            String sql = "UPDATE tbl_Laptop SET LaptopName = ?, Price = ?, Publisher = ? WHERE LaptopCode = ? ";
            preStm = conn.prepareStatement(sql);
            preStm = conn.prepareStatement(sql);
            preStm.setString(4, dto.getLaptopCode());
            preStm.setString(1, dto.getLaptopName());
            preStm.setFloat(2, dto.getPrice());
            preStm.setString(3, dto.getPublisher());
            
            check = preStm.executeUpdate()> 0;
        } finally {
            closeConnect();
        }
        return check;
    }
    
    public boolean delete(String code)  throws Exception
    {
        boolean check = false;
        try {
            conn = MyConnection.getConnection();
            String sql = "DELETE FROM  tbl_Laptop WHERE LaptopCode = ? ";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, code);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnect();
        }
        return check;
    }
}
