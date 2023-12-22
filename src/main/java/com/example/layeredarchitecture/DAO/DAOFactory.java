/* Created By Sithira Roneth
 * Date :12/22/23
 * Time :11:49
 * Project Name :working
 * */
package com.example.layeredarchitecture.DAO;

import com.example.layeredarchitecture.DAO.Impl.CustomerDAOImpl;
import com.example.layeredarchitecture.DAO.Impl.ItemDAOImpl;
import com.example.layeredarchitecture.DAO.Impl.OrderDAOImpl;
import com.example.layeredarchitecture.DAO.Impl.OrderDetailDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;
    private DAOFactory(){}
    public static DAOFactory getDaoFactory(){
        return daoFactory == null ? daoFactory = new DAOFactory() : daoFactory;
    }
    public enum DAOTypes{
        CUSTOMER,ITEM,ORDERS,ORDER_DETAIL
    }
    public SuperDAO getDAO(DAOTypes daoTypes){
        switch (daoTypes){
            case CUSTOMER:
                return new CustomerDAOImpl();
            case ITEM:
                return new ItemDAOImpl();
            case ORDERS:
                return new OrderDAOImpl();
            case ORDER_DETAIL:
                return new OrderDetailDAOImpl();
            default:
                return null;
        }
    }
}
