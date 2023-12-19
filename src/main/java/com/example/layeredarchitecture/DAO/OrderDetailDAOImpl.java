/* Created By Sithira Roneth
 * Date :12/18/23
 * Time :21:13
 * Project Name :working
 * */
package com.example.layeredarchitecture.DAO;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.OrderDetailDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class OrderDetailDAOImpl implements OrderDetailDAO {
    @Override
    public boolean SavedOrderDetails(OrderDetailDTO dto) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement stm = connection.prepareStatement("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)");
        stm.setString(1, dto.getOid());
        stm.setString(2, dto.getItemCode());
        stm.setBigDecimal(3, dto.getUnitPrice());
        stm.setInt(4, dto.getQty());
        return stm.executeUpdate()>0;
    }

}
