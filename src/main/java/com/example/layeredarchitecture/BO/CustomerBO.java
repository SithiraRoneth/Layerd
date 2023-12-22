package com.example.layeredarchitecture.BO;

import com.example.layeredarchitecture.BO.BOImpl.SuperBO;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerBO extends SuperBO {
    ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException;
    boolean SaveCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException;
    boolean updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException;
    boolean existCustomer(String id) throws SQLException, ClassNotFoundException;

    boolean DeleteCustomer(String id) throws SQLException, ClassNotFoundException;

    String generateNextCustomerId() throws SQLException, ClassNotFoundException;
}
