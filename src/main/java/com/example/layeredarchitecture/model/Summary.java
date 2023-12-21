/* Created By Sithira Roneth
 * Date :12/21/23
 * Time :18:58
 * Project Name :working
 * */
package com.example.layeredarchitecture.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Summary {
    private String oid;
    private LocalDate date;
    private String customerID;
    private String itemCode;
    private String desc;
    private int qty;
    private BigDecimal unitPrice;

    public Summary(){
    }

    public Summary(String oid, LocalDate date, String customerID, String itemCode, String desc, int qty, BigDecimal unitPrice) {
        this.oid = oid;
        this.date = date;
        this.customerID = customerID;
        this.itemCode = itemCode;
        this.desc = desc;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "Details{" +
                "oid='" + oid + '\'' +
                ", date=" + date +
                ", customerID='" + customerID + '\'' +
                ", itemCode='" + itemCode + '\'' +
                ", desc='" + desc + '\'' +
                ", qty=" + qty +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
