package com.example.layeredarchitecture.DAO;

import com.example.layeredarchitecture.model.Summary;

import java.sql.SQLException;

public interface QueryDAO {
    Summary customerItemDetails() throws SQLException, ClassNotFoundException;
}
