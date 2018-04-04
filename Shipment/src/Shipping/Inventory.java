package Shipping;

import sun.plugin.viewer.context.IExplorerAppletContext;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private List<Item> itemInventory;
    private List<Order> orders;
    private List<Shipment> shippedOrders;
    private static long ItemId;

    public Inventory(){
        itemInventory = new ArrayList<Item>();
        orders = new ArrayList<Order>();
        shippedOrders = new ArrayList<Shipment>();
        ItemId = 0;
    }

    public void addItemToInventory(String itemName, double itemPrice, int itemQuantity){
        boolean itemFound = false;
        int counter = 0;
        while (!itemFound && counter < itemInventory.size()){
            Item item = itemInventory.get(counter);
            if (item.getName().equals(itemName) && item.getPrice() == itemPrice){
                item.setQuantity(item.getQuantity() + itemQuantity);
            }
        }
        if (!itemFound){
            Item item = new Item(++ItemId, itemName, itemQuantity, itemPrice);
            itemInventory.add(item);
        }
    }

    public void findItem(String itemName){
        boolean itemFound = false;
        int counter = 0;
        Item item = null;
        while (!itemFound && counter<itemInventory.size()){
            item = itemInventory.get(counter);
            if (item.getName().equals(itemName)){
                itemFound = true;
            }
            counter++;
        }
        if (itemFound){
            item = null;
        }
        return;
    }

    public void createOrder(Item item){
        Order order = new Order(item);
        orders.add(order);
    }

    public int findItemQuantity(long ItemId){
        int quantity = -1;
        if (ItemId <= itemInventory.size()){
            Item item = itemInventory.get((int) ItemId);
            quantity =  item.getQuantity();
        }
        return quantity;
    }
}
