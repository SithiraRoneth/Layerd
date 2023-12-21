/* Created By Sithira Roneth
 * Date :12/18/23
 * Time :22:13
 * Project Name :working
 * */
package com.example.layeredarchitecture.controller;

import com.example.layeredarchitecture.DAO.Impl.QueryDAOImpl;
import com.example.layeredarchitecture.DAO.QueryDAO;
import com.example.layeredarchitecture.DAO.SQLUtil;
import com.example.layeredarchitecture.model.Summary;
import javafx.event.ActionEvent;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SearchOrderController {
    QueryDAO queryDAO = new QueryDAOImpl();
    public void btnPrintOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Summary summary = queryDAO.customerItemDetails();
        System.out.println(summary);
    }
}
