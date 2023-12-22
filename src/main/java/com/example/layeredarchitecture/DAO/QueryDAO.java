package com.example.layeredarchitecture.DAO;

import com.example.layeredarchitecture.model.SummaryDto;

import java.sql.SQLException;

public interface QueryDAO {
    SummaryDto customerItemDetails() throws SQLException, ClassNotFoundException;
}
