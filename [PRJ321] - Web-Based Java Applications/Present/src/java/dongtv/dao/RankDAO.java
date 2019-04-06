/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dongtv.dao;

import dongtv.dto.RankDTO;
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
public class RankDAO implements Serializable{
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
    
    public boolean create(RankDTO dto) throws Exception{
        boolean res = false;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "INSERT INTO Ranks(Username,EventId,Point) VALUES(?,?,?)";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getUsername());
            preStm.setInt(2, dto.getEventId());
            preStm.setInt(3, dto.getPoint());
            res = preStm.executeUpdate() > 0;
        }catch(Exception e)
        {
            res =false;
        }
        finally {
            closeConnect();
        }
        return res;
    }
    
    public RankDTO get(String username, int eventId ) throws Exception
    {
        RankDTO res = null;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "SELECT Point,PrizeId FROM Ranks WHERE Username = ? AND EventId = ? ";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            preStm.setInt(2, eventId);
            rs =preStm.executeQuery();
            if(rs.next())
            {
                res = new RankDTO(username, eventId, rs.getInt("Point"),rs.getInt("PrizeId"));
            }
        } finally{
            closeConnect();
        }
        return res;
    }
    
    public boolean update(RankDTO dto) throws Exception
    {
        boolean res = false;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "UPDATE Ranks SET Point = ? WHERE Username = ? AND EventId = ? ";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, dto.getPoint());
            preStm.setString(2, dto.getUsername());
            preStm.setInt(3, dto.getEventId());
            res = preStm.executeUpdate() > 0;
        }finally {
            closeConnect();
        }
        return res;
    }
    
    public boolean updateRanks(RankDTO dto) throws Exception
    {
        boolean res = false;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "UPDATE Ranks SET PrizeId = ? WHERE Username = ? AND EventId = ? ";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, dto.getPrizeId());
            preStm.setString(2, dto.getUsername());
            preStm.setInt(3, dto.getEventId());
            res = preStm.executeUpdate() > 0;
        }finally {
            closeConnect();
        }
        return res;
    }
    
    public List<RankDTO> search(int eventId ) throws Exception
    {
        List<RankDTO> res = new ArrayList<>();
        try {
            conn = MyConnection.getMyConnection();
            String sql = "SELECT Username,Point,PrizeId FROM Ranks WHERE  EventId = ? ORDER BY Point DESC";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, eventId);
            rs =preStm.executeQuery();
            while(rs.next())
            {
                res.add(new RankDTO(rs.getString("Username"), eventId, rs.getInt("Point"),rs.getInt("PrizeId"))) ;
            }
        } finally{
            closeConnect();
        }
        return res;
    }
    
    public List<RankDTO> search(String username) throws Exception
    {
        List<RankDTO> res = new ArrayList<>();
        try {
            conn = MyConnection.getMyConnection();
            String sql = "SELECT EventId,Point,PrizeId FROM Ranks WHERE  Username = ? ";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            rs =preStm.executeQuery();
            while(rs.next())
            {
                res.add(new RankDTO(username, rs.getInt("EventId"), rs.getInt("Point"),rs.getInt("PrizeId"))) ;
            }
        } finally{
            closeConnect();
        }
        return res;
    }
}
