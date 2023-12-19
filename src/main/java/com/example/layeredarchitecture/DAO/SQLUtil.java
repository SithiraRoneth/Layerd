/* Created By Sithira Roneth
 * Date :12/19/23
 * Time :11:40
 * Project Name :working
 * */
package com.example.layeredarchitecture.DAO;

import com.example.layeredarchitecture.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLUtil {
    public static <T> T execute(String sql, Object...ob) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        for (int i =0 ; i < ob.length; i++){
            pstm.setObject((i+1),ob[i]);
        }
        if (sql.startsWith("SELECT")){
             return (T) pstm.executeQuery();
        }else {
            return (T) (Boolean)(pstm.executeUpdate()>0);
        }
    }
}