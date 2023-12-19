/* Created By Sithira Roneth
 * Date :12/15/23
 * Time :12:33
 * Project Name :working
 * */
package com.example.layeredarchitecture.DAO;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.ItemDTO;


import java.sql.*;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO{
    @Override
    public ArrayList<ItemDTO> loadAllItem() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT * FROM Item");

        ArrayList<ItemDTO>getAllItem = new ArrayList<>();
        while (rst.next()){
            ItemDTO itemDTO = new ItemDTO(
                    rst.getString("code"), rst.getString("description"), rst.getBigDecimal("unitPrice"), rst.getInt("qtyOnHand"));

            getAllItem.add(itemDTO);
        }
        return getAllItem;
    }
    @Override
    public boolean itemDelete(String code) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM Item WHERE code=?",code);
    }
    @Override
    public boolean itemSaved(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO Item VALUES(?,?,?,?)",dto.getCode(),dto.getDescription(),dto.getUnitPrice(),dto.getQtyOnHand());
    }
    @Override
    public boolean itemUpdate(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?",dto.getDescription(),dto.getUnitPrice(),dto.getQtyOnHand(),dto.getCode());
    }
    @Override
    public boolean isExist(String code) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT id FROM Item WHERE code=?");
        pstm.setString(1, code);
        return pstm.executeQuery().next();
    }
    @Override
    public String generateId() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        ResultSet rst = connection.createStatement().executeQuery("SELECT code FROM Item ORDER BY code DESC LIMIT 1;");
        if (rst.next()) {
            String id = rst.getString("code");
            int newItemId = Integer.parseInt(id.replace("I00-", "")) + 1;
            return String.format("I00-%03d", newItemId);
        } else {
            return "I00-001";
        }
    }
    public ItemDTO searchItem(String newItemCode) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("SELECT * FROM Item WHERE code = ? ", newItemCode);
    }

}
