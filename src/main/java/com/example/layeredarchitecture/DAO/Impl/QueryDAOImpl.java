/* Created By Sithira Roneth
 * Date :12/19/23
 * Time :15:59
 * Project Name :working
 * */
package com.example.layeredarchitecture.DAO.Impl;

import com.example.layeredarchitecture.DAO.QueryDAO;
import com.example.layeredarchitecture.DAO.SQLUtil;
import com.example.layeredarchitecture.model.SummaryDto;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryDAOImpl implements QueryDAO {
    @Override
    public SummaryDto customerItemDetails() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT o.oid,o.date,o.customerID,od.itemCode,i.description,od.qty,od.unitPrice\n" +
                        "FROM Orders o\n" +
                        "JOIN OrderDetails od ON o.oid = od.oid\n" +
                        "JOIN Item i ON od.itemCode = i.code\n" +
                        "ORDER BY od.oid ASC;");

        resultSet.next();
        return new SummaryDto(
                resultSet.getString(1),
                resultSet.getDate(2).toLocalDate(),
                resultSet.getString(3),
                resultSet.getString(4),
                resultSet.getString(5),
                resultSet.getInt(6),
                resultSet.getBigDecimal(7)
                );
    }
}
