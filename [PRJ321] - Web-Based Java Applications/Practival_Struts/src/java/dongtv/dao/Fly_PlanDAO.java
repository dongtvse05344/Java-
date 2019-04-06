/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dongtv.dao;

import dongtv.conn.MyConnection;
import dongtv.dto.Fly_PlanDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author xhunt
 */
public class Fly_PlanDAO {
    private Connection conn;
    private PreparedStatement preStm;
    private ResultSet rs;
    
    private void closeConnect() throws Exception
    {
        if(rs != null) rs.close();
        if(preStm != null) preStm.close();
        if(conn != null) conn.close();
    }
    
    public boolean insert(Fly_PlanDTO dto ) throws Exception
    {
        boolean check = false;
        try {
            conn = MyConnection.getConnection();
            String sql ="INSERT INTO Fly_Plan(FlightCode,DateFly,CustomerNo) VALUES(?,?,?)";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getFlightCode());
            preStm.setDate(2, dto.getDateFly());
            preStm.setInt(3, dto.getCustomerNo());
            check =  preStm.executeUpdate() > 0;
        } finally {
            closeConnect();
        }
        return check;
    }
}
