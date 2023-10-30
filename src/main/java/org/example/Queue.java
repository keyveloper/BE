package org.example;


class Queue<T>{
    private Object[] array;
    private int head;
    private int current;

    private int totalSize;

    private int totalIndex;

    // queue size
    private int size;

    Queue(int size){
        array = new Object[size];
        totalSize = size;
        totalIndex = totalSize -1;
        this.size = 0;
        head = 0;
        current = 0;
    }

    public void push(T data){
        if (size >= totalSize){
            throw new Exception("Queue is pull");

        }

        if (current > totalIndex){
            current = 0;
        }

        array[current] = data;
        current++;
        size++;

    }


    public T pop(){
        if(size == 0){
            throw new Exception("Queue is empty");
        }
        T firstValue = (T) array[head];
        array[head] = 0;
        size--;
        head++;

        if (head > totalIndex){
            head = 0;
        }

        return firstValue;
    }

    public int size(){
        return size;
    }

    public void clear(){
        for (int i = 0; i <= totalIndex; i++){
            array[i] = null;
        }

        current = 0;
        size = 0;
        head = 0;
    }

    public void print(){
        for (int i = 0; i < size; i++){
            System.out.println(array[i]);
        }
    }


}