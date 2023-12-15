package com.example.layeredarchitecture.DAO;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

public interface CustomerDAO {
     ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException;
     boolean customerSave(CustomerDTO dto) throws SQLException, ClassNotFoundException;
     boolean customerUpdate(String name,String address,String id) throws SQLException, ClassNotFoundException ;
     boolean existCustomer(String  id) throws SQLException, ClassNotFoundException;

     boolean customerDelete(String id) throws SQLException, ClassNotFoundException;
     String generateNextId() throws SQLException, ClassNotFoundException;
}
