package com.example.layeredarchitecture.DAO;

import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO <T> extends SuperDAO {
    ArrayList<T> getAll() throws SQLException, ClassNotFoundException;
    boolean Save(T t) throws SQLException, ClassNotFoundException;
    boolean Update(T t) throws SQLException, ClassNotFoundException ;
    boolean exist(String  id) throws SQLException, ClassNotFoundException;
    boolean Delete(String id) throws SQLException, ClassNotFoundException;
    String generateNextId() throws SQLException, ClassNotFoundException;
    T  search(String newValue) throws SQLException, ClassNotFoundException;
}
