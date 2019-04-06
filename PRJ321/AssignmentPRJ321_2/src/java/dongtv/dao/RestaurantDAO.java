/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dongtv.dao;

import static dongtv.dao.MyConnection.getMyConnection;
import dongtv.dto.RestaurantDTO;
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
public class RestaurantDAO implements Serializable{
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
    
    public boolean insert(RestaurantDTO dto) throws Exception {
        boolean result = false;
        try {
            conn = getMyConnection();
            String sql = "INSERT INTO tbl_Restaurant(RestaurantID,RestaurantName,Address,District,isDelete) VALUES(?,?,?,?,?)";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getRestaurantID());
            preStm.setString(2, dto.getRestaurantName());
            preStm.setString(3, dto.getAddress());
            preStm.setString(4, dto.getDistrict());
            preStm.setBoolean(5, false);
            result = preStm.executeUpdate() > 0;
        }
        finally {
            closeConnect();
        }
        return result;
    }
    
    public boolean delete(String code) throws Exception {
        boolean result = false;
        try {
            conn = getMyConnection();
            String sql = "UPDATE tbl_Restaurant SET isDelete = 1  WHERE RestaurantID = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, code);
            result = preStm.executeUpdate() > 0;
        } finally {
            closeConnect();
        }
        return result;
    }
    
    public boolean update(RestaurantDTO dto) throws Exception {
        boolean result = false;
        try {
            conn = getMyConnection();
            String sql = "UPDATE tbl_Restaurant SET RestaurantName = ? , Address = ?, District = ? WHERE RestaurantID = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(4, dto.getRestaurantID());
            preStm.setString(1, dto.getRestaurantName());
            preStm.setString(2, dto.getAddress());
            preStm.setString(3, dto.getDistrict());
            result = preStm.executeUpdate() > 0;
        } finally {
            closeConnect();
        }
        return result;
    }
    
    public List<RestaurantDTO> search(String district ) throws Exception {
        List<RestaurantDTO> result = new ArrayList<>();
        try {
            conn = getMyConnection();
            String sql = "SELECT RestaurantID,RestaurantName,Address,District FROM tbl_Restaurant WHERE District LIKE ? AND isDelete = 0";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, district);
            rs = preStm.executeQuery();
            while (rs.next()) {
                result.add(new RestaurantDTO(rs.getString("RestaurantID"),
                        rs.getString("RestaurantName"),
                        rs.getString("Address"),
                        rs.getString("District")));
            }
        } finally {
            closeConnect();
        }
        return result;
    }
    
    public RestaurantDTO get(String code ) throws Exception {
        RestaurantDTO result = null;
        try {
            conn = getMyConnection();
            String sql = "SELECT RestaurantID,RestaurantName,Address,District FROM tbl_Restaurant WHERE RestaurantID = ? AND isDelete = 0";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, code);
            rs = preStm.executeQuery();
            if (rs.next()) {
                result = new RestaurantDTO(rs.getString("RestaurantID"),
                        rs.getString("RestaurantName"),
                        rs.getString("Address"),
                        rs.getString("District"));
            }
        } finally {
            closeConnect();
        }
        return result;
    }
    
}
