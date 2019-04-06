/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dongtv.dao;

import dongtv.connection.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author xhunt
 */
public class RegistrationDAO {

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

    public String checkLogin(String username, String password) throws Exception {
        String role = "failed";
        try {
            conn = MyConnection.getConnection();
            String sql = "SELECT Role FROM Registrations WHERE Username = ? AND Password = ? ";
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
}
