/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dongtv.dao;

import java.io.Serializable;
import java.sql.DriverManager;

/**
 *
 * @author linh
 */
public class MyConnection implements Serializable{
    public static java.sql.Connection getMyConnection() throws Exception
    {
        java.sql.Connection conn = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1456;databaseName=PresentDb","sa","");
        return conn;
    }
}
