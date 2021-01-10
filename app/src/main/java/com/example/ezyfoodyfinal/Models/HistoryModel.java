package com.example.ezyfoodyfinal.Models;


public class HistoryModel {
    int orderImage;
    String ordername, orderprice, address,quantity, totalprice,orderNum,paydate;

    public HistoryModel(int orderImage, String ordername, String orderprice, String address,String quantity,String totalprice, String orderNum, String paydate) {
        this.orderImage = orderImage;
        this.ordername = ordername;
        this.orderprice = orderprice;
        this.address = address;
        this.quantity = quantity;
        this.totalprice = totalprice;
        this.orderNum = orderNum;
        this.paydate = paydate;
    }

    public int getOrderImage() {
        return orderImage;
    }

    public void setOrderImage(int orderImage) {
        this.orderImage = orderImage;
    }

    public String getOrdername() {
        return ordername;
    }

    public void setOrdername(String ordername) {
        this.ordername = ordername;
    }

    public String getOrderprice() {
        return orderprice;
    }

    public void setOrderprice(String orderprice) {
        this.orderprice = orderprice;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

//    public String getTotalprice() {
//        return totalprice;
//    }
//
//    public void setTotalprice(String totalprice) {
//        this.totalprice = totalprice;
//    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getPaydate() {
        return paydate;
    }

    public void setPaydate(String paydate) {
        this.paydate = paydate;
    }
}
