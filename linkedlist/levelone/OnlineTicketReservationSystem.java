package com.bridgelabz.linkedlist.levelone;

public class OnlineTicketReservationSystem {
    public static void main(String[] args) {
        TicketList ticketList = new TicketList();

        ticketList.addNodeAtStart(101, "Alice", "Interstellar", "A1", "10:00 AM");
        ticketList.addNodeAtEnd(102, "Bob", "Inception", "B2", "12:00 PM");
        ticketList.addNodeAtEnd(103, "Charlie", "Dunkirk", "C3", "2:00 PM");

        ticketList.displayNumberOfTickets();

        ticketList.searchForCustomerBasedOn(102);

        ticketList.deleteNodeByID(102);

        ticketList.displayNumberOfTickets();

        ticketList.searchForCustomerBasedOn(102);
    }
}


class TicketNode{
    private int ticketID;
    private String customerName;
    private String movieName;
    private String seatNumber;
    private String bookingTime;
    TicketNode next;

    public TicketNode(int ticketID, String customerName, String movieName, String seatNumber, String bookingTime){
        this.ticketID = ticketID;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }

    public int getTicketID() {
        return ticketID;
    }

    public String getBookingTime() {
        return bookingTime;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getSeatNumber() {
        return seatNumber;
    }
}

class TicketList{
    private TicketNode head;
    private TicketNode tail;

    public void addNodeAtStart(int ticketID, String customerName, String movieName, String seatNumber, String bookingTime){
        TicketNode newNode = new TicketNode(ticketID,customerName,movieName,seatNumber,bookingTime);

        if(head == null){
            head = tail = newNode;
            tail.next = head;
            return;
        }
        newNode.next = head;
        head = newNode;
        tail.next = newNode;
    }

    public void addNodeAtEnd(int ticketID, String customerName, String movieName, String seatNumber, String bookingTime){
        TicketNode newNode = new TicketNode(ticketID,customerName,movieName,seatNumber,bookingTime);

        if(head == null){
            head = tail = newNode;
            tail.next = head;
            return;
        }

        tail.next = newNode;
        tail = newNode;
        tail.next = head;

    }

    public void deleteNodeByID(int id){
        TicketNode temp = head;

        // if List is empty
        if(head == null) {
            System.out.println("The List is Empty");
            return;
        }

        // if the node to be deleted is the head;
        if(head.getTicketID() == id){
            if(head.next == head){
                head = tail = null;
                return;
            }
            head = head.next;
            tail.next = head;
            return;
        }

        while(temp.next != head && temp.next.getTicketID() != id) {
            temp = temp.next;
        }

        // if it reaches head that means the element dosent exist
        if (temp.next == head) {
            System.out.println("Ticket ID not found!");
            return;
        }

        // if tail is to be deleted
        if(temp.next == tail){
            temp.next = head;
            tail = temp;
            return;
        }

        // any other node in the middle
        temp.next = temp.next.next;
    }

    public void displayNumberOfTickets(){
        if(head == null){
            System.out.println("The number of Tickets Currently are: " + 0);
            return;
        }

        TicketNode temp = head;
        int count = 1;
        while(temp.next != head){
            temp = temp.next;
            count++;
        }

        System.out.println("The number of Tickets Currently are: " + count);
        System.out.println("-----------------------------------------------------");
    }

    public void searchForCustomerBasedOn(int ticketId){
        TicketNode temp = findUser(ticketId);

        if(temp == null) {
            System.out.println("NOT FOUND");
            return;
        }
        System.out.println("Found ID: " + ticketId);
        displayResults(temp);
    }

    public  TicketNode findUser(int ticketId) {
        if (head == null) return null;

        TicketNode temp = head;
        while (true) {
            if (temp.getTicketID() == ticketId) return temp;
            temp = temp.next;
            if (temp == head) break;
        }

        return null;
    }

    public void displayResults(TicketNode temp){
        System.out.println("The Ticket ID is " + temp.getTicketID());
        System.out.println("The customer Name is " + temp.getTicketID());
        System.out.println("The movie Name is " + temp.getTicketID());
        System.out.println("The seat Number is " + temp.getTicketID());
        System.out.println("The booking Time is " + temp.getTicketID());
        System.out.println("-----------------------------------------------------");
    }
}
