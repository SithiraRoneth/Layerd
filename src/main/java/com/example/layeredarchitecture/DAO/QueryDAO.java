package com.example.layeredarchitecture.DAO;

import java.sql.SQLException;

public interface QueryDAO {
    boolean customerItemDetails() throws SQLException, ClassNotFoundException;
}
