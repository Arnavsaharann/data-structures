package com.bridgelabz.linkedlist.levelone;

import java.util.Scanner;

class Student {
    int rollNumber;
    String name;
    int age;
    char grade;
    Student next;

    public Student(int roll, String name, int age, char grade) {
        this.rollNumber = roll;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

class StudentList {
    private Student head;

    // Add student at the beginning
    public void addStudentAtBeginning(int roll, String name, int age, char grade) {
        Student newStudent = new Student(roll, name, age, grade);
        newStudent.next = head;
        head = newStudent;
    }

    // Add student at the end
    public void addStudentAtEnd(int roll, String name, int age, char grade) {
        Student newStudent = new Student(roll, name, age, grade);
        if (head == null) {
            head = newStudent;
            return;
        }
        Student temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newStudent;
    }

    // Delete student by roll number
    public void deleteStudent(int roll) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        if (head.rollNumber == roll) {
            head = head.next;
            System.out.println("Student with Roll Number " + roll + " deleted.");
            return;
        }

        Student temp = head;
        while (temp.next != null && temp.next.rollNumber != roll) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Student not found!");
            return;
        }

        temp.next = temp.next.next;
        System.out.println("Student with Roll Number " + roll + " deleted.");
    }

    // Search student by roll number
    public void searchStudent(int roll) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNumber == roll) {
                System.out.println("Student Found: " + temp.name + " | Age: " + temp.age + " | Grade: " + temp.grade);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found!");
    }

    // Update grade by roll number
    public void updateGrade(int roll, char newGrade) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNumber == roll) {
                temp.grade = newGrade;
                System.out.println("Grade updated successfully for Roll Number " + roll);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found!");
    }

    // Display all student records
    public void displayStudents() {
        if (head == null) {
            System.out.println("No student records available!");
            return;
        }
        Student temp = head;
        System.out.println("Student Records:");
        while (temp != null) {
            System.out.println("Roll No: " + temp.rollNumber + ", Name: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
            temp = temp.next;
        }
    }
}

public class StudentRecordManagement {
    public static void main(String[] args) {
        StudentList studentList = new StudentList();
        studentList.addStudentAtEnd(1, "Alice", 20, 'A');
        studentList.addStudentAtEnd(2, "Bob", 21, 'B');
        studentList.addStudentAtBeginning(3, "Charlie", 22, 'A');

        studentList.displayStudents();
    }
}
