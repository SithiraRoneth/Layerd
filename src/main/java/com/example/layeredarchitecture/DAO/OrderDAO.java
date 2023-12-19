package com.example.layeredarchitecture.DAO;

import com.example.layeredarchitecture.model.ItemDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;

public interface OrderDAO {
     ItemDTO findItem(String code) throws SQLException, ClassNotFoundException;
     String nextId() throws SQLException, ClassNotFoundException;
     boolean saveOrderDetails(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails);
}