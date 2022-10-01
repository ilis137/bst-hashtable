package com.javapractice;

import java.util.ArrayList;

public class LinkedHashTable<K, V> {
  private final int numBuckets;
  ArrayList<LinkedList<K>> BucketArray;
  //initialize array size as 10 and initialize null at every inndex
  public LinkedHashTable() {
    this.numBuckets = 10;
    this.BucketArray = new ArrayList<>(numBuckets);
    for (int i = 0; i < numBuckets; i++) {
      this.BucketArray.add(null);
    }
  }
  //get index of array where list of hashtable nodes are stored 
  private int getBucketIndex(K key) {
    int hashCode = Math.abs(key.hashCode());
    int index = hashCode % numBuckets;
    return index;
  }
  //retreive a entry from hashtable with given key
  public V get(K key) {
    int index = this.getBucketIndex(key);//first retreive the index by hashing key
    LinkedList<K> list = this.BucketArray.get(index);//get the linked list with the index
    if (list == null)
      return null;
    MapNode<K, V> MapNode = (MapNode<K, V>) list.search(key);//search for the entry in list with key.if found return it,otherwise null
    return (MapNode == null) ? null : MapNode.getValue();
  }
  //add entry to hashtable with key and vale
  public void add(K key, V value) {
    //get index of list to find the entry with key in that list;
    int index = this.getBucketIndex(key);
    LinkedList<K> list = this.BucketArray.get(index);
    if (list == null) {//if list  is null create new linked list at that index
      list = new LinkedList<>();
      this.BucketArray.set(index, list);
    }
    MapNode<K, V> MapNode = (MapNode<K, V>) list.search(key);
    if (MapNode == null) {//if existing entry in list then update value otherwise append new node with key value pair
      MapNode = new MapNode<>(key, value);
      list.append(MapNode);
    } else {
      MapNode.setValue(value);
    }
  }
  //remove entry from hashtable
  public boolean remove(K key) {
    int index = this.getBucketIndex(key);
    LinkedList<K> list = this.BucketArray.get(index);//get the linked list and then remove entry
    boolean success = list.delete(key);
    return success;
  }

  // print hash table
  public void print() {
    for (LinkedList<K> linkedlist : BucketArray) {
      if (linkedlist != null) {
        linkedlist.printMapNodes();
      }
    }
  }

}