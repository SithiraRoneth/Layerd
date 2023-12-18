package com.example.layeredarchitecture.DAO;

import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface OrderDetailDAO {
    boolean saveOrderDetails(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails) throws SQLException, ClassNotFoundException;
}
