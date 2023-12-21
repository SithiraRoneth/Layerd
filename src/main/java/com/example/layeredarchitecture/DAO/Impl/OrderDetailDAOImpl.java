/* Created By Sithira Roneth
 * Date :12/18/23
 * Time :21:13
 * Project Name :working
 * */
package com.example.layeredarchitecture.DAO.Impl;

import com.example.layeredarchitecture.DAO.OrderDetailDAO;
import com.example.layeredarchitecture.DAO.SQLUtil;
import com.example.layeredarchitecture.model.OrderDetailDTO;
import java.sql.SQLException;

public class OrderDetailDAOImpl implements OrderDetailDAO {
    @Override
    public boolean SavedOrderDetails(OrderDetailDTO dto) throws SQLException, ClassNotFoundException {

        return SQLUtil.execute("INSERT INTO OrderDetails VALUES(?,?,?,?)",dto.getOid(),dto.getItemCode(),dto.getUnitPrice(),dto.getQty());
    }

}
