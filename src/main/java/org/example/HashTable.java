package org.example;

public class HashTable {
    private Object[] array;

    private int size;

    private class Node{
        private String key;
        private int value;

        Node(String key, int value){
            this.key = key;
            this.value = value;
        }

        public void setValue(int data){
            this.value = data;
        }
    }

    HashTable(int size){
        array = new Object[size];
        this.size = size;

        for(int i = 0; i < this.size; i++){
            array[i] = new CustomList<>(size * 2);
        }

    }
    public void set(String key, int value){
        Node newNode = new Node(key, value);
        int hash = getHash(key);
        CustomList<Object> hashList = (CustomList<Object>) array[hash];
        boolean flag = false;
        for(int i = 0; i < hashList.size(); i++){
            Node findNode = (Node) hashList.get(i);
            if(key.equals(findNode.key)){
                findNode.setValue(value);
                flag = true;
                break;
            }
        }
        if (!flag){
            hashList.add(newNode);
        }
        System.out.println("hash: " + hash);
    }

    public Object get(String key){
        int hash = getHash(key);
        CustomList<Object> hashList = (CustomList<Object>) array[hash];
        Object matchedValue = null;
        for(int i = 0; i < hashList.size(); i++){
            Node findNode = (Node) hashList.get(i);
            if(key.equals(findNode.key)){
                matchedValue = findNode.value;
                break;
            }
        }
        if (matchedValue == null){
            throw new Exception("key is not founded");
        }

        return matchedValue;
    }

    public void del(String key){
        int hash = getHash(key);
        CustomList<Object> hashList = (CustomList<Object>) array[hash];
        for(int i = 0; i < hashList.size(); i++){
            Node findNode = (Node) hashList.get(i);
            if (key.equals(findNode.key)){
                hashList.pop(i);
            }
        }
    }

    public void show(){
        for(int i = 0; i<size; i++){
            CustomList list = (CustomList) array[i];
            for (int j = 0; j < list.size(); j++){
                Node node = (Node) list.get(j);
                System.out.println("key: " + node.key + "\n" + "value: " + node.value);
            }
        }

    }

    public void clear(){
        for(int i = 0; i < size; i++){
            array[i] = null;
        }
    }

    private int getHashCode(String key){
        int hashCode = 0;

        for (char c : key.toCharArray()){
            hashCode += c;
        }

        return hashCode;
    }

    private int getHash(String key){
        int hashCode = getHashCode(key);
        int hash = hashCode % size;

        return hash;
    }
}