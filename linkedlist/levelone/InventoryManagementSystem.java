package com.bridgelabz.linkedlist.levelone;

import java.util.Scanner;

public class InventoryManagementSystem {
    public static void main(String[] args) {
        ItemList movieList = new ItemList();

        movieList.addAtStart("Pen", 101, 5, 10);
        movieList.addAtEnd("cycle", 102, 1, 15000);
        movieList.addAtStart("paper", 105, 1000, 0.5);
        movieList.addAtStart("Tooth Brush", 106, 10, 50);

        movieList.addAtIndex("human", 102, 1, 15000,4);

        movieList.displayList();
    }
}

class Item{
    private String itemName;
    private int itemID;
    private int quantity;
    private double price;
    public Item next;

    public Item(String itemName, int itemID, int quantity, double price){
        this.itemName = itemName;
        this.itemID = itemID;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }

    public int getItemID() {
        return itemID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

class ItemList{
    private Item head;

    public void addAtStart(String itemName, int itemID, int quantity, double price){
        Item newItem = new Item(itemName, itemID, quantity, price);
        newItem.next = head;
        head = newItem;
    }

    public void addAtEnd(String itemName, int itemID, int quantity, double price){
        Item newItem = new Item(itemName, itemID, quantity, price);
        if(head == null){
            head = newItem;
            return;
        }
        Item temp = head;

        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = newItem;
    }

    public void addAtIndex(String itemName, int itemID, int quantity, double price, int index){
        if(index == 0){
            addAtStart(itemName,itemID, quantity, price);
        }
        Item newItem = new Item(itemName, itemID, quantity, price);
        Item temp = head;
        while(temp != null && index > 1){
            temp = temp.next;
            index--;
        }
        if(temp == null){
            System.out.println("Index out of bounds.");
            return;
        }
        newItem.next = temp.next;
        temp.next = newItem;
    }

    public void removeItemWithItemID(int itemID){

        if(head == null){
            System.out.println("Inventory Empty");
            return;
        }
        // if item to be removed at head
        if(head.getItemID() == itemID){
            head = head.next;
            return;
        }
        // if any other item
        Item temp = head;
        Item prev = null;
        while(temp != null && temp.getItemID() != itemID){
            prev = temp;
            temp = temp.next;
        }
        if(temp == null){
            System.out.println("did not find the element to be removed: ");
            return;
        }
        if (prev != null) {
            prev.next = temp.next;
            return;
        }
    }

    public void updateQuantity(int itemID){

        if (head == null) {
            System.out.println("Inventory is empty. Cannot update quantity.");
            return;
        }
        Item temp = head;
        while (temp != null && temp.getItemID() != itemID) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Item with ID " + itemID + " not found.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter new quantity for item: ");
        int newQuantity = scanner.nextInt();
        temp.setQuantity(newQuantity);

        System.out.println("Quantity updated successfully.");
    }

    public void calculateTotalValue() {
        double totalValue = 0;
        Item temp = head;
        while (temp != null) {
            totalValue += temp.getQuantity() * temp.getPrice();
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: $" + totalValue);
    }

    public void sortByPrice(){
        if(head == null || head.next == null) return;

        for(Item i = head; i != null; i = i.next){
            for(Item j = head; j != null; j = j.next){
                if(j.getPrice() > j.next.getPrice()){
                    swap(j,j.next);
                }
            }
        }
    }

    private void swap(Item a, Item b) {
        String tempName = a.getItemName();
        int tempID = a.getItemID();
        int tempQuantity = a.getQuantity();
        double tempPrice = a.getPrice();

        a.setItemName(b.getItemName());
        a.setItemID(b.getItemID());
        a.setQuantity(b.getQuantity());
        a.setPrice(b.getPrice());

        b.setItemName(tempName);
        b.setItemID(tempID);
        b.setQuantity(tempQuantity);
        b.setPrice(tempPrice);
    }

    public void displayList(){
        if(head == null){
            return;
        }
        Item temp = head;
        while(temp != null){
            System.out.println("the itemName: " + temp.getItemName());
            System.out.println("Item ID: " + temp.getItemID());
            System.out.println("Quantity: " + temp.getQuantity());
            System.out.println("Price: " + temp.getPrice());
            System.out.println();
            temp = temp.next;
        }
    }
}
