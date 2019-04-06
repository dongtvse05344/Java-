/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dongtv.dao;

import static dongtv.dao.MyConnection.getMyConnection;
import static dongtv.dao.Utils.*;
import dongtv.dto.AccountDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author linh
 */
public class AccountDAO implements Serializable{

    private Connection conn;
    private PreparedStatement preStm;
    private ResultSet rs;

    public List<AccountDTO> getUsers() throws Exception {
        List<AccountDTO> result = new ArrayList<>();
        try {
            conn = getMyConnection();
            String sql = "SELECT Username,Name,isActive FROM Accounts WHERE RoleId IN"
                    + "   (SELECT Id FROM Roles WHERE RoleName = ?)";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, USER);
            rs = preStm.executeQuery();
            while (rs.next()) {
                result.add(new AccountDTO(rs.getString("Username"),
                        null,
                        rs.getString("Name"),
                        null,
                        null, rs.getBoolean("isActive")));
            }
        } finally {
            closeConnect();
        }
        return result;
    }

    public List<AccountDTO> search(String nameSearch) throws Exception {
        List<AccountDTO> result = new ArrayList<>();
        try {
            conn = getMyConnection();
            String sql = "SELECT Username,Name,isActive FROM Accounts WHERE RoleId IN"
                    + "   (SELECT Id FROM Roles WHERE RoleName = ? ) AND Name LIKE ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, USER);
            preStm.setString(2, "%" + nameSearch + "%");
            rs = preStm.executeQuery();
            while (rs.next()) {
                result.add(new AccountDTO(rs.getString("Username"),
                        null,
                        rs.getString("Name"),
                        null,
                        null, rs.getBoolean("isActive")));
            }
        } finally {
            closeConnect();
        }
        return result;
    }

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

    public String checkLogin(String username, String password) throws Exception {
        String result = "failed";
        try {
            conn = getMyConnection();
            String sql = "SELECT RoleName FROM Roles WHERE Id IN"
                    + "   (SELECT RoleId FROM Accounts WHERE Username = ? AND Password = ? AND isActive = 1)";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            preStm.setString(2, password);
            rs = preStm.executeQuery();
            if (rs.next()) {
                result = rs.getString("RoleName");
            }
        } finally {
            closeConnect();
        }
        return result;
    }

    public AccountDTO get(String username) throws Exception {
        AccountDTO result = null;
        try {
            conn = getMyConnection();
            String sql = "SELECT Name,Password,RoleId,Email FROM Accounts WHERE Username = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            rs = preStm.executeQuery();
            while (rs.next()) {
                result = new AccountDTO(username,
                        rs.getString("Password"),
                        rs.getString("Name"),
                        rs.getString("Email"),
                        "");
            }
        } finally {
            closeConnect();
        }
        return result;
    }

    public ArrayList<AccountDTO> getManagers() throws Exception {
        ArrayList<AccountDTO> result = new ArrayList<>();
        try {
            conn = getMyConnection();
            String sql = "SELECT Username,Name,Email FROM Accounts WHERE RoleId IN"
                    + "   (SELECT Id FROM Roles WHERE RoleName = ? OR RoleName = ? )";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, ADMIN);
            preStm.setString(2, MANAGER);
            rs = preStm.executeQuery();
            while (rs.next()) {
                result.add(new AccountDTO(rs.getString("Username"),
                        null,
                        rs.getString("Name"),
                        rs.getString("Email"),
                        null));
            }
        } finally {
            closeConnect();
        }
        return result;
    }

    public boolean unManager(String username) throws Exception {
        boolean res = false;
        try {
            int roleId = getRoleId(USER);
            conn = getMyConnection();
            String sql = "UPDATE Accounts SET RoleId = ? WHERE Username =  ? ";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, roleId);
            preStm.setString(2, username);
            res = preStm.executeUpdate() > 0;
        } finally {
            closeConnect();
        }

        return res;
    }
    
    public boolean addManager(String username) throws Exception {
        boolean res = false;
        try {
            int roleId = getRoleId(MANAGER);
            conn = getMyConnection();
            String sql = "UPDATE Accounts SET RoleId = ? WHERE Username =  ? ";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, roleId);
            preStm.setString(2, username);
            res = preStm.executeUpdate() > 0;
        } finally {
            closeConnect();
        }

        return res;
    }

    private int getRoleId(String roleName) throws Exception {
        int res = -1;
        try {
            conn = getMyConnection();
            String sql = "SELECT Id FROM Roles WHERE RoleName = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, roleName);
            rs = preStm.executeQuery();
            if (rs.next()) {
                res = rs.getInt("Id");
            }
        } finally {
            closeConnect();
        }
        return res;
    }

    public boolean create(AccountDTO dto) throws Exception {
        boolean res = false;
        try {
            int roleId = getRoleId(dto.getRole());
            conn = MyConnection.getMyConnection();
            String sql = "INSERT INTO Accounts(Username,Password,Name,Email,RoleId) VALUES(?,?,?,?,?)";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getUsername());
            preStm.setString(2, dto.getPassword());
            preStm.setString(3, dto.getName());
            preStm.setString(4, dto.getEmail());
            preStm.setInt(5, roleId);
            res = preStm.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        } finally {
            closeConnect();
        }
        return res;
    }

    public boolean changeActive(String username) throws Exception {
        boolean res = false;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Update Accounts Set isActive = (Select isActive From Accounts WHERE Username = ?)-1"
                    + " WHERE Username =?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            preStm.setString(2, username);
            res = preStm.executeUpdate() > 0;
        } finally {
            closeConnect();
        }
        return res;
    }
    
     public boolean changePassword(String username,String password) throws Exception {
        boolean res = false;
        try {
            conn = MyConnection.getMyConnection();
            String sql = "Update Accounts Set Password = ? From Accounts WHERE Username = ?";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, password);
            preStm.setString(2, username);
            res = preStm.executeUpdate() > 0;
        } finally {
            closeConnect();
        }
        return res;
    }

}
