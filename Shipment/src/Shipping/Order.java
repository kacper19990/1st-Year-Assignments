package Shipping;

import Shipping.Item;

import java.util.*;

public class Order {

    private int orderID;
    private Item orderedItem;
    private Date orderDate;

    public Order(Item orderedItem) {
        this.orderedItem = orderedItem;
        orderDate = Calendar.getInstance().getTime();
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public Item getOrderedItem() {
        return orderedItem;
    }

    public void setOrderedItem(Item orderedItem) {
        this.orderedItem = orderedItem;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

}