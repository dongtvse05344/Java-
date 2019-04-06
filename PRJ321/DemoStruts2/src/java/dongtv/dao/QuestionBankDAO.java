/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dongtv.dao;

import dongtv.connection.MyConnection;
import dongtv.dto.QuestionBankDTO;
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
public class QuestionBankDAO implements Serializable{
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
    
    public List<QuestionBankDTO> search(String search) throws Exception
    {
        List<QuestionBankDTO> result = new ArrayList<>();
        try {
            conn = MyConnection.getConnection();
            String sql = "SELECT id,name,chap,ques,used FROM tbl_Questions_PRM WHERE ques LIKE ? ";
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, search);
            rs = preStm.executeQuery();
            while(rs.next())
            {
                result.add(new QuestionBankDTO(rs.getInt("id"),
                                            rs.getString("name"), 
                                            rs.getString("chap"),
                                            rs.getString("ques"), null, null, null, null,
                                            rs.getBoolean("used")));
            }
        } finally {
            closeConnect();
        }
        return result;
    }
    
    public boolean delete(int id) throws Exception
    {
        boolean check = false;
        try {
            conn = MyConnection.getConnection();
            String sql ="DELETE FROM tbl_Questions_PRM WHERE id = ? ";
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, id);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnect();
        }
        return check;
    }
}
