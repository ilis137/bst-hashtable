package com.javapractice;


public class HashTable<K, V> {
    LinkedList<K> list;

    public HashTable(){
        this.list = new LinkedList<>();

    }
    //get the value of said key
    public V get(K key) {
        MapNode<K,V> MapNode = (MapNode<K,V>)list.search(key);
        return (MapNode == null) ? null : MapNode.getValue();
    }
    //find the node in linkedlist and if found update it or create new one.
    public void add(K key, V value) {
        MapNode<K,V> MapNode = (MapNode<K, V>) this.list.search(key);
        if (MapNode == null){
            MapNode = new MapNode<>(key,value);
            this.list.append(MapNode);
        }else {
            MapNode.setValue(value);
        }
    }
    //print hash table
    public void print(){
    list.printMapNodes();
    }

}