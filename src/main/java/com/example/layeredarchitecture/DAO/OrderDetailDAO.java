package com.example.layeredarchitecture.DAO;

import com.example.layeredarchitecture.model.OrderDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface OrderDetailDAO extends CrudDAO<OrderDetailDTO>{
    //boolean SavedOrderDetails(OrderDetailDTO orderDetailDTO) throws SQLException, ClassNotFoundException;
}
