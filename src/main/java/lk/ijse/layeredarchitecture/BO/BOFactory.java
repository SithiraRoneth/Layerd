/* Created By Sithira Roneth
 * Date :12/22/23
 * Time :13:41
 * Project Name :working
 * */
package lk.ijse.layeredarchitecture.BO;

import lk.ijse.layeredarchitecture.BO.Custom.BOImpl.CustomerBOImpl;
import lk.ijse.layeredarchitecture.BO.Custom.BOImpl.ItemBOImpl;
import lk.ijse.layeredarchitecture.BO.Custom.BOImpl.PlaceOrderBOImpl;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory(){

    }
    public static BOFactory getBOFactory(){
        return boFactory == null ? boFactory = new BOFactory() : boFactory;
    }
    public enum BOTypes{
        CUSTOMER,ITEM,ORDERS
    }
    public SuperBO getBO(BOTypes boTypes){
        switch (boTypes){
            case CUSTOMER:
                return new CustomerBOImpl();
            case ITEM:
                return new ItemBOImpl();
            case ORDERS:
                return new PlaceOrderBOImpl();
            default:
                return null;
        }
    }
}
