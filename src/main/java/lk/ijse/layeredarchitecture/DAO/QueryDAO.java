package lk.ijse.layeredarchitecture.DAO;

import lk.ijse.layeredarchitecture.Dto.SummaryDto;

import java.sql.SQLException;

public interface QueryDAO {
    SummaryDto customerItemDetails() throws SQLException, ClassNotFoundException;
}
