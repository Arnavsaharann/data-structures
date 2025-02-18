package com.bridgelabz.linkedlist.levelone;

class MovieNode {
    String title;
    String director;
    int year;
    double rating;
    MovieNode next;
    MovieNode prev;

    public MovieNode(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}

class MovieList {
    private MovieNode head;
    private MovieNode tail;

    public void insertMovieAtHead(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Insert movie at the end
    public void insertMovieAtEnd(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Insert movie at a specific position
    public void insertMovieAtPosition(String title, String director, int year, double rating, int position) {
        if (position <= 1) {
            insertMovieAtHead(title, director, year, rating);
            return;
        }

        MovieNode newNode = new MovieNode(title, director, year, rating);
        MovieNode temp = head;
        int count = 1;

        while (temp != null && count < position - 1) {
            temp = temp.next;
            count++;
        }

        if (temp == null || temp.next == null) {
            insertMovieAtEnd(title, director, year, rating);
        } else {
            newNode.next = temp.next;
            newNode.prev = temp;
            temp.next.prev = newNode;
            temp.next = newNode;
        }
    }

    // Remove movie by title
    public void removeMovieByTitle(String title) {
        MovieNode temp = head;

        while (temp != null) {
            if (temp.title.equals(title)) {
                if (temp == head) {
                    head = temp.next;
                    if (head != null) head.prev = null;
                } else if (temp == tail) {
                    tail = temp.prev;
                    if (tail != null) tail.next = null;
                } else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found.");
    }

    // Search movie by director
    public void searchByDirector(String director) {
        MovieNode temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.director.equals(director)) {
                System.out.println("Title: " + temp.title + ", Year: " + temp.year + ", Rating: " + temp.rating);
                found = true;
            }
            temp = temp.next;
        }

        if (!found) System.out.println("No movies found for director: " + director);
    }

    // Search movie by rating
    public void searchByRating(double rating) {
        MovieNode temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.rating == rating) {
                System.out.println("Title: " + temp.title + ", Director: " + temp.director + ", Year: " + temp.year);
                found = true;
            }
            temp = temp.next;
        }

        if (!found) System.out.println("No movies found with rating: " + rating);
    }

    // Display movies in forward order
    public void displayForward() {
        MovieNode temp = head;
        if (temp == null) {
            System.out.println("No movies in the list.");
            return;
        }
        while (temp != null) {
            System.out.println(temp.title + " | " + temp.director + " | " + temp.year + " | " + temp.rating);
            temp = temp.next;
        }
    }

    // Display movies in reverse order
    public void displayReverse() {
        MovieNode temp = tail;
        if (temp == null) {
            System.out.println("No movies in the list.");
            return;
        }
        while (temp != null) {
            System.out.println(temp.title + " | " + temp.director + " | " + temp.year + " | " + temp.rating);
            temp = temp.prev;
        }
    }

    // Update rating of a movie by title
    public void updateRating(String title, double newRating) {
        MovieNode temp = head;

        while (temp != null) {
            if (temp.title.equals(title)) {
                temp.rating = newRating;
                System.out.println("Updated " + title + " rating to " + newRating);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found.");
    }
}

// Main class to test the system
public class MovieManagementSystem {
    public static void main(String[] args) {
        MovieList movieList = new MovieList();

        // Adding movies
        movieList.insertMovieAtEnd("Inception", "Christopher Nolan", 2010, 8.8);
        movieList.insertMovieAtEnd("Interstellar", "Christopher Nolan", 2014, 8.6);
        movieList.insertMovieAtHead("The Matrix", "Wachowski Sisters", 1999, 8.7);
        movieList.insertMovieAtPosition("The Dark Knight", "Christopher Nolan", 2008, 9.0, 2);

        // Display movies
        System.out.println("Movies in forward order:");
        movieList.displayForward();

        System.out.println("\nMovies in reverse order:");
        movieList.displayReverse();

        // Search movies
        System.out.println("\nSearch movies by director:");
        movieList.searchByDirector("Christopher Nolan");

        System.out.println("\nSearch movies by rating:");
        movieList.searchByRating(8.6);

        // Update movie rating
        movieList.updateRating("Interstellar", 9.0);

        // Remove a movie
        movieList.removeMovieByTitle("The Matrix");

        // Display updated list
        System.out.println("\nUpdated movie list:");
        movieList.displayForward();
    }
}
