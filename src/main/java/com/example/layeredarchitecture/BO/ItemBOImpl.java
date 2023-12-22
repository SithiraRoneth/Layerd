/* Created By Sithira Roneth
 * Date :12/22/23
 * Time :10:35
 * Project Name :working
 * */
package com.example.layeredarchitecture.BO;

import com.example.layeredarchitecture.DAO.Impl.ItemDAOImpl;
import com.example.layeredarchitecture.DAO.ItemDAO;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBOImpl implements ItemBO{
    ItemDAO itemDAO = new ItemDAOImpl();

    @Override
    public ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException {
        return itemDAO.getAll();
    }

    @Override
    public boolean SaveItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return itemDAO.Save(dto);
    }

    @Override
    public boolean updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return itemDAO.Update(dto);
    }

    @Override
    public boolean existItem(String code) throws SQLException, ClassNotFoundException {
        return itemDAO.exist(code);
    }

    @Override
    public boolean DeleteItem(String code) throws SQLException, ClassNotFoundException {
        return itemDAO.Delete(code);
    }

    @Override
    public String generateNextItemId() throws SQLException, ClassNotFoundException {
        return itemDAO.generateNextId();
    }
}
