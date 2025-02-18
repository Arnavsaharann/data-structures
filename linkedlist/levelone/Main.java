package com.bridgelabz.linkedlist.levelone;

public class Main {
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();

        scheduler.addTaskAtEnd(1, 101, "High", "2025-03-01");
        scheduler.addTaskAtEnd(2, 102, "Medium", "2025-03-05");
        scheduler.addTaskAtHead(3, 103, "Low", "2025-03-10");

        System.out.println("All Tasks:");
        scheduler.displayTasks();

        scheduler.removeTaskById(102);

        System.out.println("\nAll Tasks after removal:");
        scheduler.displayTasks();

        System.out.println("\nSearch for tasks with Medium priority:");
        scheduler.searchTaskByPriority("Medium");

        scheduler.viewAndMoveToNextTask();
    }
}

class Node {
    private int taskID;
    private int taskName;
    private String priority;
    private String dueDate;
    Node next;

    public Node(int taskID, int taskName, String priority, String dueDate) {
        this.taskID = taskID;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }

    public void display() {
        System.out.println("TaskID: " + taskID + ", TaskName: " + taskName +
                ", Priority: " + priority + ", DueDate: " + dueDate);
    }

    public int getTaskID() {
        return taskID;
    }

    public String getPriority() {
        return priority;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

class TaskScheduler {
    private Node head;
    private Node current;

    public TaskScheduler() {
        head = null;
        current = null;
    }

    public void addTaskAtHead(int taskID, int taskName, String priority, String dueDate) {
        Node newNode = new Node(taskID, taskName, priority, dueDate);
        if (head == null) {
            head = newNode;
            head.setNext(head);
            current = head;
        } else {
            newNode.setNext(head);
            head = newNode;
            if (current == null) {
                current = head;
            }
            current.setNext(head);
        }
    }

    public void addTaskAtEnd(int taskID, int taskName, String priority, String dueDate) {
        Node newNode = new Node(taskID, taskName, priority, dueDate);
        if (head == null) {
            head = newNode;
            head.setNext(head);
        } else {
            Node temp = head;
            while (temp.getNext() != head) {
                temp = temp.getNext();
            }
            temp.setNext(newNode);
            newNode.setNext(head);
        }
    }

    public void removeTaskById(int taskID) {
        if (head == null) return;

        Node temp = head;
        Node prev = null;

        if (temp.getTaskID() == taskID) {
            while (temp.getNext() != head) {
                temp = temp.getNext();
            }
            if (head == head.getNext()) {
                head = null;
            } else {
                temp.setNext(head.getNext());
                head = head.getNext();
            }
            return;
        }

        while (temp != head && temp.getTaskID() != taskID) {
            prev = temp;
            temp = temp.getNext();
        }

        if (temp == head) {
            System.out.println("Task not found!");
            return;
        }

        prev.setNext(temp.getNext());
    }

    public void displayTasks() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        Node temp = head;
        do {
            temp.display();
            temp = temp.getNext();
        } while (temp != head);
    }

    public void searchTaskByPriority(String priority) {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        Node temp = head;
        boolean found = false;
        do {
            if (temp.getPriority().equalsIgnoreCase(priority)) {
                temp.display();
                found = true;
            }
            temp = temp.getNext();
        } while (temp != head);

        if (!found) {
            System.out.println("No tasks found with priority: " + priority);
        }
    }

    public void viewAndMoveToNextTask() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        if (current == null) {
            current = head;
        }
        current.display();
        current = current.getNext();
    }
}
