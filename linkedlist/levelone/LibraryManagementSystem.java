package com.bridgelabz.linkedlist.levelone;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        BookList booklist = new BookList();


        booklist.addAtStart("ABC","MAYANK", "HORROR", 101, true);
        booklist.addAtEnd("CDE","ARNAV", "COMEDY", 102, true);
        booklist.addAtStart("GFH","RUPESH", "ACTION", 109, true);
        booklist.addAtStart("LUY","ARPIT", "ACTION", 120, true);


        booklist.changeAvailibility("ABC");

        booklist.searchForBookByTitle("SFE");

        System.out.println("----------------------------------------------------");

        booklist.displayInForwardOrder();

        System.out.println("----------------------------------------------------");

        booklist.displayInReverseOrder();

    }
}

class BookNode{
    private String title;
    private String author;
    private String genre;
    private int ID;
    private boolean isAvailable;

    public BookNode next;
    public BookNode prev;

    public BookNode(String title, String author, String genre, int ID, boolean isAvailable){
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.ID = ID;
        this.isAvailable = isAvailable;
        this.next = null;
        this.prev = null;
    }

    public int getID() {
        return ID;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getAuthor() {
        return author;
    }
    public boolean getIsAvailable(){
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}

class BookList{
    BookNode head;
    BookNode tail;

    public void addAtStart(String title, String author, String genre, int ID, boolean isAvailable){
        BookNode newBook = new BookNode(title,author,genre,ID,isAvailable);

        if (head == null) {
            head = tail = newBook;
        }else{
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
    }


    public void addAtEnd(String title, String author, String genre, int ID, boolean isAvailable){
        BookNode newBook = new BookNode(title,author,genre,ID,isAvailable);
        if (head == null) {
            head = tail = newBook;
            return;
        }
        tail.next = newBook;
        newBook.prev = tail;
        tail = newBook;
    }

    public void addAtIndex(String title, String author, String genre, int ID, boolean isAvailable,int index){

        if(index == 0){
            addAtStart(title,author,genre,ID,isAvailable);
        }

        BookNode newBook = new BookNode(title,author,genre,ID,isAvailable);
        BookNode temp = head;
        while(temp != null && index > 1){
            temp = temp.next;
            index--;
        }

        if(temp == null){
            System.out.println("out of bounds of the list: ");
            return;
        }

        newBook.next = temp.next;
        newBook.prev = temp;
        temp.next = newBook;
    }

    public void removeBookByID(int ID){
        if(head == null){
            System.out.println("Inventory Empty");
            return;
        }

        // If the head node is the one to be deleted
        if (head.getID() == ID) {
            if (head.next == null) { // If there's only one node
                head = null;
                tail = null; // Update tail as well
            } else {
                head = head.next;
                head.prev = null;
            }
        }
        // Traverse the list to find the node to delete
        BookNode temp = head;
        while (temp != null && temp.getID() != ID) {
            temp = temp.next;
        }

        // If book is not found
        if (temp == null) {
            System.out.println("Book not found");
            return;
        }

        // If deleting the last node (tail)
        if (temp == tail) {
            tail = tail.prev;
            tail.next = null;
            return;
        }

        // If deleting a node in the middle
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
    }

    public void searchForBookByTitle(String title){

        if(head == null){
            System.out.println("Inventory Empty");
            return;
        }

        BookNode temp = head;
        while(temp != null){
            if(temp.getTitle() == title){
                System.out.println("Book Found:");
                System.out.println("Title: " + temp.getTitle());
                System.out.println("Author: " + temp.getAuthor());
                System.out.println("Genre: " + temp.getGenre());
                System.out.println("ID: " + temp.getID());
                System.out.println("Availability: " + (temp.getIsAvailable() ? "Available" : "Not Available"));
                return;
            }
            temp = temp.next;
        }
        if(temp == null){
            System.out.println("could not find the book :" + title);
        }
    }

    public void changeAvailibility(String title){

        if(head == null){
            System.out.println("Inventory Empty");
            return;
        }

        BookNode temp = head;
        while(temp != null){
            if(temp.getTitle().equals(title)){
                if(temp.getIsAvailable() == true) {
                    temp.setAvailable(false);
                }else{
                    System.out.println("Already taken (Unavailable)");
                }
            }
            temp = temp.next;
        }
    }

    public void displayInForwardOrder(){

        if(head == null){
            System.out.println("Inventory Empty");
            return;
        }

        BookNode temp = head;
        while(temp != null){
            System.out.println("Title: " + temp.getTitle());
            System.out.println("Author: " + temp.getAuthor());
            System.out.println("Genre: " + temp.getGenre());
            System.out.println("ID: " + temp.getID());
            System.out.println("Availability: " + (temp.getIsAvailable() ? "Available" : "Not Available"));
            System.out.println();

            temp = temp.next;
        }
    }

    public void displayInReverseOrder(){

        if(head == null){
            System.out.println("Inventory Empty");
            return;
        }

        BookNode temp = tail;
        while(temp != null){
            System.out.println("Book Found:");
            System.out.println("Title: " + temp.getTitle());
            System.out.println("Author: " + temp.getAuthor());
            System.out.println("Genre: " + temp.getGenre());
            System.out.println("ID: " + temp.getID());
            System.out.println("Availability: " + (temp.getIsAvailable() ? "Available" : "Not Available"));
            System.out.println();

            temp = temp.prev;
        }
    }
}
