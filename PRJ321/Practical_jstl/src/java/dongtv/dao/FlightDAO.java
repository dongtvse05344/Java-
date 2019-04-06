package dongtv.dao;


import dongtv.conn.MyConnection;
import dongtv.dto.FlightDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author xhunt
 */
public class FlightDAO implements Serializable{
    private Connection conn;
    private PreparedStatement preStm;
    private ResultSet rs;
    
    private void closeConnect() throws Exception
    {
        if(rs != null) rs.close();
        if(preStm != null) preStm.close();
        if(conn != null) conn.close();
    }
    
    public List<FlightDTO> getAll() throws Exception
    {
        List<FlightDTO> result = new ArrayList<>();
        try {
            conn = MyConnection.getConnection();
            String sql = "SELECT Code,Name From Flights WHERE isActive = 1";
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            while(rs.next())
            {
                result.add(new FlightDTO(rs.getString("Code"), rs.getString("Name"), null, 0));
            }
        } finally {
            closeConnect();
        }
        return result;
    }
    
    public FlightDTO get(String code) throws Exception
    {
        FlightDTO result = null;
        try {
            conn = MyConnection.getConnection();
            String sql = "SELECT Name,Color,ChairNo From Flights WHERE Code = ? ";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, code);
            rs = preStm.executeQuery();
            while(rs.next())
            {
                result =  new FlightDTO(code, rs.getString("Name"), rs.getString("Color"), rs.getInt("ChairNo"));
            }
        } finally {
            closeConnect();
        }
        return result;
    }
    
}
