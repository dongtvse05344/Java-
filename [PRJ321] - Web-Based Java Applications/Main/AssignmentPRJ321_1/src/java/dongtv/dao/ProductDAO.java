/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dongtv.dao;

import static dongtv.dao.MyConnection.getMyConnection;
import dongtv.dto.ProductDTO;
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
public class ProductDAO implements Serializable {

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

    public List<ProductDTO> search(float a, float b) throws Exception {
        List<ProductDTO> result = new ArrayList<>();
        try {
            conn = getMyConnection();
            String sql = "SELECT ProductID,ProductName,ProductPrice,Description,Status FROM tbl_Product WHERE ProductPrice >= ? AND ProductPrice <= ?  AND Status = 'available' ORDER BY ProductName  ";
            preStm = conn.prepareStatement(sql);
            preStm.setFloat(1, a);
            preStm.setFloat(2, b);
            rs = preStm.executeQuery();
            while (rs.next()) {
                result.add(new ProductDTO(rs.getString("ProductID"),
                        rs.getString("ProductName"),
                        rs.getFloat("ProductPrice"),
                        rs.getString("Description"),
                        rs.getString("Status")));
            }
        } finally {
            closeConnect();
        }
        return result;
    }
    
    

    public ProductDTO get(String id) throws Exception {
        ProductDTO result = null;
        try {
            conn = getMyConnection();
            String sql = "SELECT ProductName,ProductPrice,Description,Status FROM tbl_Product WHERE ProductID = ? ";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, id);
            rs = preStm.executeQuery();
            if (rs.next()) {
                result = new ProductDTO(id,
                        rs.getString("ProductName"),
                        rs.getFloat("ProductPrice"),
                        rs.getString("Description"),
                        rs.getString("Status"));
            }
        } finally {
            closeConnect();
        }
        return result;
    }

    public boolean insert(ProductDTO dto) throws Exception {
        boolean result = false;
        try {
            conn = getMyConnection();
            String sql = "INSERT INTO tbl_Product(ProductID,ProductName,ProductPrice,Description,Status) VALUES(?,?,?,?,?)";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getProductID());
            preStm.setString(2, dto.getProductName());
            preStm.setFloat(3, dto.getProductPrice());
            preStm.setString(4, dto.getDescription());
            preStm.setString(5, dto.getStatus());
            result = preStm.executeUpdate() > 0;
        }
        finally {
            closeConnect();
        }
        return result;
    }

    public boolean update(ProductDTO dto) throws Exception {
        boolean result = false;
        try {
            conn = getMyConnection();
            String sql = "UPDATE tbl_Product SET ProductName = ? , ProductPrice = ?, Description = ?, Status = ?  WHERE ProductID = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(5, dto.getProductID());
            preStm.setString(1, dto.getProductName());
            preStm.setFloat(2, dto.getProductPrice());
            preStm.setString(3, dto.getDescription());
            preStm.setString(4, dto.getStatus());
            result = preStm.executeUpdate() > 0;
        } finally {
            closeConnect();
        }
        return result;
    }

    public boolean delete(String code) throws Exception {
        boolean result = false;
        try {
            conn = getMyConnection();
            String sql = "DELETE FROM tbl_Product WHERE ProductID = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, code);
            result = preStm.executeUpdate() > 0;
        } finally {
            closeConnect();
        }
        return result;
    }
}
