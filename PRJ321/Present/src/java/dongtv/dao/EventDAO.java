/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dongtv.dao;

import dongtv.dto.EventDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author xhunt
 */
public class EventDAO implements Serializable{
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
    
    public List<EventDTO> getAll() throws Exception
    {
        List<EventDTO> res = new LinkedList<>();
        try {
            conn = MyConnection.getMyConnection();
            String sql ="SELECT Id,Name,DateStarted,Banner,ManagerId FROM Events ";
            preStm = conn.prepareStatement(sql);
            rs =preStm.executeQuery();
            while(rs.next())
            {
                res.add(new EventDTO(rs.getInt("Id"),
                                    rs.getString("Name"),
                                    null,
                                    rs.getTimestamp("DateStarted"),
                                    null,
                                    rs.getString("ManagerId"),
                                    rs.getString("Banner"),
                                    null,
                                    null,
                                    0));
            }
        } finally{
            closeConnect();
        }
        return res;
    }
    
    public List<EventDTO> getEventsFuture() throws Exception
    {
        List<EventDTO> res = new LinkedList<>();
        try {
            conn = MyConnection.getMyConnection();
            String sql ="SELECT Id,Name,DateStarted,ManagerId,Description,Banner,NoUser FROM Events WHERE GetDate() < DateStarted  ";
            preStm = conn.prepareStatement(sql);
            rs =preStm.executeQuery();
            while(rs.next())
            {
                res.add(new EventDTO(rs.getInt("Id"),
                                    rs.getString("Name"),
                                    null,
                                    rs.getTimestamp("DateStarted"),
                                    null,
                                    rs.getString("ManagerId"),
                                    rs.getString("Banner"),
                                    null,
                                    rs.getNString("Description"),
                                    rs.getInt("NoUser")));
            }
        } finally{
            closeConnect();
        }
        return res;
    }
    
    public List<EventDTO> searchEvents(String nameSearch) throws Exception
    {
        List<EventDTO> res = new LinkedList<>();
        try {
            conn = MyConnection.getMyConnection();
            String sql ="SELECT Id,Name,DateStarted,Banner,ManagerId FROM Events WHERE Name LIKE ?  ";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%"+nameSearch+"%");
            rs =preStm.executeQuery();
            while(rs.next())
            {
                res.add(new EventDTO(rs.getInt("Id"),
                                    rs.getString("Name"),
                                    null,
                                    rs.getTimestamp("DateStarted"),
                                    null,
                                    rs.getString("ManagerId"),
                                    rs.getString("Banner"),
                                    null,
                                    null,
                                    0));
            }
        } finally{
            closeConnect();
        }
        return res;
    }
    
    public List<EventDTO> getEventsPast() throws Exception
    {
        List<EventDTO> res = new LinkedList<>();
        try {
            conn = MyConnection.getMyConnection();
            String sql ="SELECT Id,Name,DateStarted,Banner,ManagerId FROM Events WHERE DateEnded < GetDate()";
            preStm = conn.prepareStatement(sql);
            rs =preStm.executeQuery();
            while(rs.next())
            {
                res.add(new EventDTO(rs.getInt("Id"),
                                    rs.getString("Name"),
                                    null,
                                    rs.getTimestamp("DateStarted"),
                                    null,
                                    rs.getString("ManagerId"),
                                    rs.getString("Banner"),
                                    null,
                                    null,
                                    0));
            }
        } finally{
            closeConnect();
        }
        return res;
    }
    
    public List<EventDTO> getEventsNow() throws Exception
    {
        List<EventDTO> res = new LinkedList<>();
        try {
            conn = MyConnection.getMyConnection();
            String sql ="SELECT Id,Name,DateStarted,Banner,ManagerId FROM Events WHERE  DateStarted<= GetDate() AND GetDate() <= DateEnded ";
            preStm = conn.prepareStatement(sql);
            rs =preStm.executeQuery();
            while(rs.next())
            {
                res.add(new EventDTO(rs.getInt("Id"),
                                    rs.getString("Name"),
                                    null,
                                    rs.getTimestamp("DateStarted"),
                                    null,
                                    rs.getString("ManagerId"),
                                    rs.getString("Banner"),
                                    null,
                                    null,
                                    0));
            }
        } finally{
            closeConnect();
        }
        return res;
    }
    
    public List<EventDTO> getEventsNow(String username) throws Exception
    {
        List<EventDTO> res = new LinkedList<>();
        try {
            conn = MyConnection.getMyConnection();
            String sql ="SELECT Id,Name,DateStarted,Banner FROM Events WHERE  DateStarted<= GetDate() AND GetDate() <= DateEnded AND ManagerId = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            rs =preStm.executeQuery();
            while(rs.next())
            {
                res.add(new EventDTO(rs.getInt("Id"),
                                    rs.getString("Name"),
                                    null,
                                    rs.getTimestamp("DateStarted"),
                                    null,
                                    null,
                                    rs.getString("Banner"),
                                    null,
                                    null,
                                    0));
            }
        } finally{
            closeConnect();
        }
        return res;
    }
    
    public EventDTO get(int id) throws Exception
    {
        EventDTO res = null;
        try {
            conn = MyConnection.getMyConnection();
            String sql ="SELECT Name,DateCreated,DateStarted,DateEnded,ManagerId,Location,Description,Banner,NoUser FROM Events WHERE Id = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, id);
            rs =preStm.executeQuery();
            if(rs.next())
            {
                res =new EventDTO(id,
                                    rs.getString("Name"),
                                    rs.getTimestamp("DateCreated"),
                                    rs.getTimestamp("DateStarted"),
                                    rs.getTimestamp("DateEnded"),
                                    rs.getString("ManagerId"),
                                    rs.getString("Banner"),
                                    rs.getString("Location"),
                                    rs.getNString("Description"),
                                    rs.getInt("NoUser"));
            }
        } finally{
            closeConnect();
        }
        return res;
    }
    
    public int create(EventDTO dto)  throws Exception
    {
        int res = -1;
        try {
            conn = MyConnection.getMyConnection();
            String sql ="INSERT INTO Events(Name,DateCreated,DateStarted,DateEnded,ManagerId,Banner,Location,Description,NoUser) "
                    + " OUTPUT Inserted.ID"
                    + " VALUES(?,?,?,?,?,?,?,?,?)";
            preStm =conn.prepareStatement(sql);
            preStm.setString(1, dto.getName());
            preStm.setTimestamp(2, dto.getDateCreated());
            preStm.setTimestamp(3, dto.getDateStarted());
            preStm.setTimestamp(4, dto.getDateEnded());
            preStm.setString(5, dto.getManagerId());
            preStm.setString(6, dto.getBanner());
            preStm.setString(7, dto.getLocation());
            preStm.setNString(8, dto.getDescription());
            preStm.setInt(9, dto.getNoUser());
            rs = preStm.executeQuery();
            if(rs.next())
            {
                res = rs.getInt("ID");
            }
        } finally {
            closeConnect();
        }
        return res;
    }
    
    public boolean update(EventDTO dto) throws Exception
    {
        boolean res = false;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "UPDATE Events SET Name = ? , DateCreated = ? , DateStarted = ?,DateEnded = ?,"
                    + " ManagerId =? ,Location = ? , Description = ?, NoUser = ?, Banner = ? "
                    + "  WHERE Id=? ";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getName());
            preStm.setTimestamp(2, dto.getDateCreated());
            preStm.setTimestamp(3, dto.getDateStarted());
            preStm.setTimestamp(4, dto.getDateEnded());
            preStm.setString(5,dto.getManagerId() );
            preStm.setString(6, dto.getLocation());
            preStm.setString(7, dto.getDescription());
            preStm.setInt(8, dto.getNoUser());
            preStm.setString(9, dto.getBanner());
            preStm.setInt(10, dto.getId());
            res = preStm.executeUpdate() > 0;
        }finally {
            closeConnect();
        }
        return res;
    }
}
