package org.example;

public class Stack <T>{
    private Object[] array;
    private int top;
    private int totalSize;
    private int size;

    public Stack(int size){
        totalSize = size;
        array = new Object[size];
        top = 0;
        this.size = 0;
    }

    public void push(T data){
        if (size > totalSize){
            throw new Exception("stack is full!");
        }
        array[top] = data;
        top++;
        size++;

    }

    public T pop(){
        if (size == 0){
            throw new Exception("stack is empty");
        }
        T lastValue = (T) array[top - 1];
        array[top] = 0;
        size--;
        top--;

        return lastValue;
    }

    public void clear(){
        for (int i = 0; i < totalSize; i++){
            array[i] = null;

        }
        size = 0;
        top = 0;
    }

    public int size(){
        return this.size;
    }

    public void print(){
        for (int i = 0; i < size; i++){
            System.out.println(array[i]);
        }
    }


}

