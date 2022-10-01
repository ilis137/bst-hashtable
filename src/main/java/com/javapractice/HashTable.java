package com.javapractice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HashTable<K, V> {
    LinkedList<K> list;

    public HashTable(){
        this.list = new LinkedList<>();

    }
    //get the value of said key
    public V get(K key) {
        MapNode<K,V> myMapNode = (MapNode<K,V>)list.search(key);
        return (myMapNode == null) ? null : myMapNode.getValue();
    }
    //find the node in linkedlist and if found update it or create new one.
    public void add(K key, V value) {
        MapNode<K,V> myMapNode = (MapNode<K, V>) this.list.search(key);
        if (myMapNode == null){
            myMapNode = new MapNode<>(key,value);
            this.list.append(myMapNode);
        }else {
            myMapNode.setValue(value);
        }
    }

    public void print(){
    list.printMapNodes();
    }

}