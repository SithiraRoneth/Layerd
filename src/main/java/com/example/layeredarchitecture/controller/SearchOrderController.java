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
import com.example.layeredarchitecture.view.tdm.SummaryTM;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SearchOrderController {
    public TableView<SummaryTM> tblSummary;
    @FXML
    private TableColumn<?, ?> ColCode;

    @FXML
    private TableColumn<?, ?> colCId;

    @FXML
    private TableColumn<?, ?> colDate;

    @FXML
    private TableColumn<?, ?> colDesc;

    @FXML
    private TableColumn<?, ?> colOID;

    @FXML
    private TableColumn<?, ?> colQty;

    @FXML
    private TableColumn<?, ?> colprice;

    QueryDAO queryDAO = new QueryDAOImpl();

    public void initialize(){
        colOID.setCellValueFactory(new PropertyValueFactory<>("oid"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colCId.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        ColCode.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        colDesc.setCellValueFactory(new PropertyValueFactory<>("desc"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colprice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
    }
    public void btnPrintOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Summary summary = queryDAO.customerItemDetails();
        System.out.println(summary);
         tblSummary.getItems().add(new SummaryTM(
                 summary.getOid(),
                 summary.getDate(),
                 summary.getCustomerID(),
                 summary.getItemCode(),
                 summary.getDesc(),
                 summary.getQty(),
                 summary.getUnitPrice()));
         tblSummary.refresh();
    }
}
