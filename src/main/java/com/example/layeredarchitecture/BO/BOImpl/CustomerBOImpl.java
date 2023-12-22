/* Created By Sithira Roneth
 * Date :12/22/23
 * Time :10:24
 * Project Name :working
 * */
package com.example.layeredarchitecture.BO.BOImpl;

import com.example.layeredarchitecture.BO.CustomerBO;
import com.example.layeredarchitecture.DAO.CustomerDAO;
import com.example.layeredarchitecture.DAO.DAOFactory;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {
    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    @Override
    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException {
        return customerDAO.getAll();
    }

    @Override
    public boolean SaveCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return customerDAO.Save(dto);
    }
    @Override
    public boolean updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return customerDAO.Update(dto);
    }

    @Override
    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.exist(id);
    }
    @Override
    public boolean DeleteCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.Delete(id);
    }
    @Override
    public String generateNextCustomerId() throws SQLException, ClassNotFoundException {
        return customerDAO.generateNextId();
    }
}
