/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dongtv.dao;

import dongtv.dto.PrizeDTO;
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
public class PrizeDAO implements Serializable{
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
    
    public List<PrizeDTO> getAll() throws Exception
    {
        List<PrizeDTO> result  = new ArrayList<>();
        try {
            conn = MyConnection.getMyConnection();
            String sql = "SELECT Id,Name,Description,Image FROM Prizes ";
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            while(rs.next())
            {
                result.add(new PrizeDTO( rs.getInt("Id"),rs.getString("Name"),rs.getString("Description"),rs.getString("Image")));
            }
        }finally {
        }
        return result;                                                                                                                                                                                                                                                                                  
    }
    
    public PrizeDTO get(int id) throws Exception
    {
        PrizeDTO result = null;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "SELECT Name,Description,Image FROM Prizes WHERE Id = ? ";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, id);
            rs = preStm.executeQuery();
            if(rs.next())
            {
                result = new PrizeDTO(id, rs.getString("Name"), rs.getString("Description"), rs.getString("Image"));
            }
        } finally {
            closeConnect();
        }
        return result;
    }
    
    public boolean create(PrizeDTO dto) throws Exception
    {
        boolean check = false;
        try {
            conn = MyConnection.getMyConnection();
            String sql ="INSERT INTO Prizes(Name,Description) VALUES(?,?) ";
            preStm = conn.prepareStatement(sql);
            preStm.setNString(1, dto.getName());
            preStm.setNString(2, dto.getDescription());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnect();
        }
        return check;
    }
    
    public boolean update(PrizeDTO dto) throws Exception
    {
        boolean check = false;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "UPDATE Prizes SET Name = ? , Description = ? WHERE id = ? ";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getName());
            preStm.setString(2, dto.getDescription());
            preStm.setInt(3, dto.getId());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnect();
        }
        return check;
    }
}
