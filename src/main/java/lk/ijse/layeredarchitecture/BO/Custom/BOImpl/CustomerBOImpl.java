/* Created By Sithira Roneth
 * Date :12/22/23
 * Time :10:24
 * Project Name :working
 * */
package lk.ijse.layeredarchitecture.BO.Custom.BOImpl;

import lk.ijse.layeredarchitecture.BO.Custom.CustomerBO;
import lk.ijse.layeredarchitecture.DAO.Custom.CustomerDAO;
import lk.ijse.layeredarchitecture.DAO.DAOFactory;
import lk.ijse.layeredarchitecture.Dto.CustomerDTO;
import lk.ijse.layeredarchitecture.Entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {
    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    @Override
    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException {
        ArrayList<CustomerDTO>customerDTOS = new ArrayList<>();
        ArrayList<Customer>customers = customerDAO.getAll();
        for (Customer customer:customers) {
            customerDTOS.add(new CustomerDTO(customer.getId(),customer.getName(),customer.getAddress()));

        }
        return customerDTOS;
    }

    @Override
    public boolean SaveCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return customerDAO.Save(new Customer(dto.getId(),dto.getName(),dto.getAddress()));
    }
    @Override
    public boolean updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return customerDAO.Update(new Customer(dto.getId(),dto.getName(),dto.getAddress()));
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
