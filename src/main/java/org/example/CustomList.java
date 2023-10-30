package org.example;

public class CustomList <T> {
    private T[] array;
    private int totalSize;
    private int size;
    private int current;

    private int lastIdx;

    public CustomList(int size){
        totalSize = size;
        array = (T[]) new Object[size];
        this.size = 0;
        current = 0;
        lastIdx = totalSize - 1;
    }

    public void add(T data){
        if (size >= totalSize){
            reBuild();
        }

        array[current] = data;
        current++;
        size++;
    }

    public void pop(int idx){
        if(size == 0){
            throw new Exception("List is empty");
        }

        if (idx == lastIdx){
            array[idx] = null;
        }

        else{
            for(int i = idx; i < totalSize - 1; i++){
                array[i] = array[i + 1];
            }
        }
        current--;
        size--;
    }

    public int size(){return this.size;}

    public Object get(int idx){
        if (idx >= totalSize){
            throw new Exception("index is out of range");
        }
        return array[idx];
    }

    private void reBuild(){
        int newSize = totalSize + 10;
        T[] newArray =  (T[]) new Object[newSize];
        for (int i = 0; i < totalSize; i++){
            newArray[i] = array[i];
        }

        totalSize = newSize;
        lastIdx = totalSize - 1;

        array = newArray;

    }

    public void clear(){
        for(int i = 0; i < totalSize; i++){
            array[i] = null;
        }
    }

    public void print(){
        for (T element : array){
            System.out.println(element);
        }

    }
}