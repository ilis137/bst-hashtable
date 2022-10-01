package com.javapractice;

public class MapNode<K, V> implements INode<K> {

    K key;
    V value;
    MapNode<K, V> next;

    public MapNode(K key , V value){
        this.key = key;
        this.value = value;
        next =null;
    }

    
    public K getKey() {
        return key;
    }

    
    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return this.value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public INode getNext() {
        return next;
    }

    @Override
    public void setNext(INode<K> next) {
        this.next = (MapNode<K,V>)next;
    }

    public String toString(){
        StringBuilder myMapNodeString = new StringBuilder();
        myMapNodeString.append("MyMapNode{" + "Key is ='").append(key)
                .append("' and Value is='").append(value).append("'}");
        if (next != null)
            myMapNodeString.append("->").append(next);
        return myMapNodeString.toString();

    }
}
