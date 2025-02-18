package com.bridgelabz.linkedlist.levelone;

public class SinglyLinkedListImplementation {
    public static void main(String[] args) {
        Linkedlist linkedlist = new Linkedlist();

        // Inserting nodes at different positions
        linkedlist.insertAtHead(2); // Insert 2 at head
        linkedlist.insertAtHead(1); // Insert 1 at head
        linkedlist.insertAtTail(4); // Insert 4 at tail
        linkedlist.insertAtIndex(2, 3); // Insert 3 at index 2

        // Displaying the linked list
        linkedlist.display();
    }
}

// Node class representing each element of the linked list
class ListNode {
    private int data; // Stores data of the node
    ListNode next; // Reference to the next node

    // Constructor to initialize node with data
    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }

    // Getter method to access data
    public int getData() {
        return data;
    }
}

// Linked list implementation class
class Linkedlist {
    private ListNode head; // Reference to the head of the list

    // Method to insert a new node at the beginning of the linked list
    public void insertAtHead(int data) {
        ListNode newNode = new ListNode(data);
        newNode.next = head; // Point new node to the current head
        head = newNode; // Update head to the new node
    }

    // Method to insert a new node at the end of the linked list
    public void insertAtTail(int data) {
        ListNode newNode = new ListNode(data);
        if (head == null) { // If list is empty, make new node the head
            head = newNode;
            return;
        }
        ListNode temp = head;
        while (temp.next != null) { // Traverse to the last node
            temp = temp.next;
        }
        temp.next = newNode; // Attach new node at the end
    }

    // Method to delete a node by its value
    public void deleteByValue(int value) {
        if (head == null) { // If list is empty
            System.out.println("List is empty!");
            return;
        }

        if (head.getData() == value) { // If head node contains the value
            head = head.next; // Move head pointer to the next node
            System.out.println("Node with value " + value + " deleted.");
            return;
        }

        ListNode temp = head;
        // Traverse the list to find the node to delete
        while (temp.next != null && temp.next.getData() != value) {
            temp = temp.next;
        }

        if (temp.next == null) { // If node with the given value is not found
            System.out.println("Node with value " + value + " not found.");
        } else {
            temp.next = temp.next.next; // Remove the node from the list
            System.out.println("Node with value " + value + " deleted.");
        }
    }

    // Method to insert a node at a specific index
    public void insertAtIndex(int idx, int data) {
        if (idx == 0) { // If index is 0, insert at head
            insertAtHead(data);
            return;
        }

        int count = 0;
        ListNode newNode = new ListNode(data);
        ListNode temp = head;

        // Traverse to the (idx-1)th node
        while (temp != null && count < idx - 1) {
            temp = temp.next;
            count++;
        }

        // If index is out of bounds, do not insert
        if (temp == null) {
            System.out.println("Index out of bounds. Insertion failed.");
            return;
        }

        // Insert new node at given index
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Method to display the linked list
    public void display() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        ListNode temp = head;
        while (temp != null) { // Traverse through the list
            System.out.print(temp.getData() + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL"); // Indicate the end of the list
    }
}
