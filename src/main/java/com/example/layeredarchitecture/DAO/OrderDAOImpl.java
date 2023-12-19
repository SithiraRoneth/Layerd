/* Created By Sithira Roneth
 * Date :12/15/23
 * Time :14:06
 * Project Name :working
 * */
package com.example.layeredarchitecture.DAO;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.ItemDTO;
import com.example.layeredarchitecture.model.OrderDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;


import java.sql.*;
import java.time.LocalDate;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {

    @Override
    public ItemDTO findItem(String code) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Item WHERE code=?");
        pstm.setString(1, code);
        ResultSet rst = pstm.executeQuery();
        rst.next();

        return null;
    }

    @Override
    public String nextId() throws SQLException, ClassNotFoundException {

        Connection connection = DBConnection.getDbConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT oid FROM `Orders` ORDER BY oid DESC LIMIT 1;");

        return rst.next() ? String.format("OID-%03d", (Integer.parseInt(rst.getString("oid").replace("OID-", "")) + 1)) : "OID-001";
    }

    @Override
    public boolean saveOrderDetails(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails) throws SQLException, ClassNotFoundException {
       return false;
    }
    @Override
    public boolean isExists(String orderId) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement stm = connection.prepareStatement("SELECT oid FROM `Orders` WHERE oid=?");
        stm.setString(1, orderId);
        return stm.executeQuery().next();
    }
    @Override
    public boolean orderSaved(OrderDTO dto) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement stm = connection.prepareStatement("INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)");
        stm.setString(1, dto.getOrderId());
        stm.setDate(2, Date.valueOf(dto.getOrderDate()));
        stm.setString(3,dto.getCustomerId());

        return stm.executeUpdate()>0;
    }
}
