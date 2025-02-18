package com.bridgelabz.linkedlist.levelone;

class ProcessNode {
    int processID, burstTime, remainingTime, waitingTime, turnaroundTime;
    ProcessNode next;

    public ProcessNode(int processID, int burstTime) {
        this.processID = processID;
        this.burstTime = burstTime;
        this.remainingTime = burstTime; // Initially, remaining time = burst time
        this.waitingTime = 0;
        this.turnaroundTime = 0;
        this.next = null;
    }
}

class RoundRobinScheduler {
    private ProcessNode head = null, tail = null;

    // Add process to circular linked list
    public void addProcess(int processID, int burstTime) {
        ProcessNode newNode = new ProcessNode(processID, burstTime);
        if (head == null) {
            head = newNode;
            newNode.next = head; // Circular link
        } else {
            tail.next = newNode;
            newNode.next = head; // Maintain circular structure
        }
        tail = newNode;
    }

    // Remove process from circular linked list
    private void removeProcessByID(int processID) {
        if (head == null) return;

        ProcessNode current = head, prev = null;
        while (current.next != head) {
            if (current.processID == processID) break;
            prev = current;
            current = current.next;
        }

        if (current.processID == processID) {
            if (current == head && current == tail) {
                head = tail = null;
            } else if (current == head) {
                head = head.next;
                tail.next = head;
            } else if (current == tail) {
                prev.next = head;
                tail = prev;
            } else {
                prev.next = current.next;
            }
        }
    }

    // Simulate Round Robin CPU Scheduling
    public void simulateRoundRobin(int timeQuantum) {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        int totalProcesses = 0, totalWaitingTime = 0, totalTurnaroundTime = 0;
        ProcessNode current = head;

        System.out.println("Executing Processes:");
        while (head != null) {
            if (current.remainingTime > timeQuantum) {
                System.out.println("Process " + current.processID + " executed for " + timeQuantum + " units.");
                current.remainingTime -= timeQuantum;
            } else {
                System.out.println("Process " + current.processID + " completed execution.");
                current.turnaroundTime = current.waitingTime + current.burstTime;
                totalWaitingTime += current.waitingTime;
                totalTurnaroundTime += current.turnaroundTime;
                totalProcesses++;

                ProcessNode temp = current;
                current = current.next;
                removeProcessByID(temp.processID);
                if (head == null) break;
                continue;
            }

            // Update waiting times for remaining processes
            ProcessNode temp = current.next;
            while (temp != current) {
                if (temp.remainingTime > 0) {
                    temp.waitingTime += timeQuantum;
                }
                temp = temp.next;
            }

            current = current.next;
        }

        // Calculate and display averages
        if (totalProcesses > 0) {
            double avgWaitingTime = (double) totalWaitingTime / totalProcesses;
            double avgTurnaroundTime = (double) totalTurnaroundTime / totalProcesses;
            System.out.println("Average Waiting Time: " + avgWaitingTime);
            System.out.println("Average Turnaround Time: " + avgTurnaroundTime);
        }
    }
}

public class RoundRobinSchedulingAlgorithm {
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler();

        scheduler.addProcess(1, 10);
        scheduler.addProcess(2, 5);
        scheduler.addProcess(3, 8);
        scheduler.addProcess(4, 6);

        int timeQuantum = 4;
        scheduler.simulateRoundRobin(timeQuantum);
    }
}
