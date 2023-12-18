/* Created By Sithira Roneth
 * Date :12/18/23
 * Time :21:13
 * Project Name :working
 * */
package com.example.layeredarchitecture.DAO;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.ItemDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class OrderDetailDAOImpl implements OrderDetailDAO {
    ItemDAO itemDAO = new ItemDAOImpl();

    public boolean saveOrderDetails(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement stm;
        stm = connection.prepareStatement("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)");

        for (OrderDetailDTO detail : orderDetails) {
            stm.setString(1, orderId);
            stm.setString(2, detail.getItemCode());
            stm.setBigDecimal(3, detail.getUnitPrice());
            stm.setInt(4, detail.getQty());

            if (stm.executeUpdate() != 1) {
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }

            ItemDTO item = itemDAO.searchItem(detail.getItemCode());
            item.setQtyOnHand(item.getQtyOnHand() - detail.getQty());

            boolean isUpdate = itemDAO.itemUpdate(item);

            if (!isUpdate) {
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }

        }
        return true;
    }

}
