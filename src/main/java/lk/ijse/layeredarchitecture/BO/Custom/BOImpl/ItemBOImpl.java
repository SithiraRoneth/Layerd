/* Created By Sithira Roneth
 * Date :12/22/23
 * Time :10:35
 * Project Name :working
 * */
package lk.ijse.layeredarchitecture.BO.Custom.BOImpl;

import lk.ijse.layeredarchitecture.BO.BOFactory;
import lk.ijse.layeredarchitecture.BO.Custom.ItemBO;
import lk.ijse.layeredarchitecture.DAO.Custom.ItemDAO;
import lk.ijse.layeredarchitecture.Dto.ItemDTO;
import lk.ijse.layeredarchitecture.Entity.Item;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBOImpl implements ItemBO {
    ItemDAO itemDAO = (ItemDAO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.ITEM);
    @Override
    public ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException {
        ArrayList<ItemDTO>itemDTOS = new ArrayList<>();
        ArrayList<Item>items = itemDAO.getAll();
        for (Item item:items) {
            itemDTOS.add(new ItemDTO(item.getCode(),item.getDescription(),item.getUnitPrice(),item.getQtyOnHand()));
        }
        return itemDTOS;
    }

    @Override
    public boolean SaveItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return itemDAO.Save(new Item(dto.getCode(),dto.getDescription(),dto.getUnitPrice(),dto.getQtyOnHand()));
    }

    @Override
    public boolean updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return itemDAO.Update(new Item(dto.getCode(),dto.getDescription(),dto.getUnitPrice(),dto.getQtyOnHand()));
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
