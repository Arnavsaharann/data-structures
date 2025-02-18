package com.bridgelabz.linkedlist.levelone;

class TextNode {
    private String text;
    TextNode prev, next;

    public TextNode(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}

class TextEditor {
    private TextNode head, tail, current;

    public void addTextState(String text) {
        TextNode newNode = new TextNode(text);
        if (head == null) {
            head = tail = current = newNode;
            return;
        }

        if (current.next != null) {
            current.next.prev = null;
            current.next = null;
        }

        current.next = newNode;
        newNode.prev = current;
        current = newNode;
        tail = newNode;
    }

    public void undo() {
        if (current == null || current.prev == null) {
            System.out.println("No undo available.");
            return;
        }
        current = current.prev;
        System.out.println("Undo: " + current.getText());
    }

    public void redo() {
        if (current == null || current.next == null) {
            System.out.println("No redo available.");
            return;
        }
        current = current.next;
        System.out.println("Redo: " + current.getText());
    }

    public void displayCurrentState() {
        System.out.println("Current Text: " + (current != null ? current.getText() : "No text available."));
    }
}

public class UndoRedoFunctionalityForTextEditor {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        editor.addTextState("Hello");
        editor.addTextState("Hello World");
        editor.addTextState("Hello World!");

        editor.displayCurrentState();

        editor.undo();
        editor.undo();
        editor.undo();

        editor.redo();
        editor.redo();
        editor.redo();

        editor.undo();
        editor.addTextState("Hello Java");

        editor.displayCurrentState();
        editor.redo();
    }
}
