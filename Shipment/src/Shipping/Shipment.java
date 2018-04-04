package Shipping;

import java.util.Date;

import java.util.*;

public class Shipment {
    private Date arrivalDate;
    private Item shippedItem;

    public Shipment(Item shippedItem) {
        this.shippedItem = shippedItem;
        arrivalDate = Calendar.getInstance().getTime();
    }

    public void createShipment(Shipment shipment){

    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Item getShippedItem() {
        return shippedItem;
    }

    public void setShippedItem(Item shippedItem) {
        this.shippedItem = shippedItem;
    }

}