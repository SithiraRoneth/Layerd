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
import java.util.ArrayList;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {
    @Override
    public ArrayList<OrderDTO> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean Save(OrderDTO dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO Orders VALUES(?,?,?)",dto.getOrderId(),dto.getOrderDate(),dto.getCustomerId());

    }

    @Override
    public boolean Update(OrderDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        ResultSet resultSet= SQLUtil.execute("SELECT oid FROM `Orders` WHERE oid=?");
        return resultSet.next();
    }

    @Override
    public boolean Delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String generateNextId() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT oid FROM `Orders` ORDER BY oid DESC LIMIT 1;");
        return rst.next() ? String.format("OID-%03d", (Integer.parseInt(rst.getString("oid").replace("OID-", "")) + 1)) : "OID-001";
    }

    @Override
    public OrderDTO search(String newValue) throws SQLException, ClassNotFoundException {
        return null;
    }


}
