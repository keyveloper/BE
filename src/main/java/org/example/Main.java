package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack(10);
        HashTable hashTable = new HashTable(3);
        Queue queue = new Queue(10);

        stack.push(1);
        stack.push("dda");
        stack.push(hashTable);
        stack.pop();

        stack.print();

        queue.push(stack.pop());
        queue.push(stack.pop());
        queue.print();
    }
}