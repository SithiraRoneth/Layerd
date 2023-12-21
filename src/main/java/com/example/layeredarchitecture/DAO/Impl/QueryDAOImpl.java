/* Created By Sithira Roneth
 * Date :12/19/23
 * Time :15:59
 * Project Name :working
 * */
package com.example.layeredarchitecture.DAO.Impl;

import com.example.layeredarchitecture.DAO.QueryDAO;
import com.example.layeredarchitecture.DAO.SQLUtil;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryDAOImpl implements QueryDAO {
    @Override
    public boolean customerItemDetails() throws SQLException, ClassNotFoundException {
            ResultSet resultSet = SQLUtil.execute("select\n" +
                    "    c.id,\n" +
                    "    c.name,\n" +
                    "    o.oid,\n" +
                    "    o.date,\n" +
                    "    od.itemCode,\n" +
                    "    od.qty,\n" +
                    "    od.unitPrice\n" +
                    "from customer c\n" +
                    "join orders o\n" +
                    "on c.id = o.customerID\n" +
                    "join orderdetails od on o.oid = od.oid\n" +
                    "join item i on od.itemCode = i.code\n" +
                    "where o.oid = (select o.oid from orders order by oid desc limit 1);");

            while (resultSet.next()) {
                String customerId = resultSet.getString("id");
                String customerName = resultSet.getString("name");
                String orderId = resultSet.getString("oid");
                String orderDate = resultSet.getString("date");
                String itemCode = resultSet.getString("itemCode");
                int quantity = resultSet.getInt("qty");
                BigDecimal unitPrice = resultSet.getBigDecimal("unitPrice");

                System.out.println("Customer ID: " + customerId);
                System.out.println("Customer Name: " + customerName);
                System.out.println("Order ID: " + orderId);
                System.out.println("Order Date: " + orderDate);
                System.out.println("Item Code: " + itemCode);
                System.out.println("Quantity: " + quantity);
                System.out.println("Unit Price: " + unitPrice);
            }
            return resultSet.next();
    }
}
