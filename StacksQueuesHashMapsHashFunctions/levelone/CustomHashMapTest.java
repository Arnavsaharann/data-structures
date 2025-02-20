package com.bridgelabz.StacksQueuesHashMapsHashFunctions.levelone;

import java.util.LinkedList;

// Custom HashMap implementation using separate chaining for collision handling
class CustomHashMap<K, V> { // Using Generics: K (Key), V (Value)
    private static class Entry<K, V> { // Inner class to store key-value pairs
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private static final int SIZE = 10; // Fixed size for simplicity
    private LinkedList<Entry<K, V>>[] buckets; // Array of LinkedLists for chaining

    @SuppressWarnings("unchecked")
    public CustomHashMap() {
        buckets = new LinkedList[SIZE]; // Create an array of LinkedLists
        for (int i = 0; i < SIZE; i++) {
            buckets[i] = new LinkedList<>(); // Initialize each LinkedList
        }
    }

    private int getBucketIndex(K key) {
        return Math.abs(key.hashCode() % SIZE); // Get bucket index using hash function
    }

    public void put(K key, V value) { // Insert or update key-value pair
        int index = getBucketIndex(key);
        for (Entry<K, V> entry : buckets[index]) {
            if (entry.key.equals(key)) {
                entry.value = value; // Update value if key already exists
                return;
            }
        }
        buckets[index].add(new Entry<>(key, value)); // Insert new key-value pair
    }

    public V get(K key) { // Retrieve value by key
        int index = getBucketIndex(key);
        for (Entry<K, V> entry : buckets[index]) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null; // Key not found
    }

    public void remove(K key) { // Remove key-value pair
        int index = getBucketIndex(key);
        buckets[index].removeIf(entry -> entry.key.equals(key));
    }

    public void print() { // Print all key-value pairs for debugging
        for (int i = 0; i < SIZE; i++) {
            if (!buckets[i].isEmpty()) {
                System.out.print("Bucket " + i + " -> ");
                for (Entry<K, V> entry : buckets[i]) {
                    System.out.print("[" + entry.key + "=" + entry.value + "] ");
                }
                System.out.println();
            }
        }
    }
}

// Main class to test CustomHashMap
public class CustomHashMapTest {
    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();

        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);
        map.put("Four", 4);

        System.out.println("Value for 'Three': " + map.get("Three")); // Output: 3

        map.remove("Two");
        System.out.println("Value for 'Two' after removal: " + map.get("Two")); // Output: null

        map.print(); // Debugging: Print all key-value pairs
    }
}
