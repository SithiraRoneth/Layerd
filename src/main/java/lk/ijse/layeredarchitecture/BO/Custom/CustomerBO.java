package lk.ijse.layeredarchitecture.BO.Custom;

import lk.ijse.layeredarchitecture.BO.SuperBO;
import lk.ijse.layeredarchitecture.Dto.CustomerDTO;

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
