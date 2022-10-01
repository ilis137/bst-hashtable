package com.javapractice;

import java.util.ArrayList;

public class LinkedHashTable<K, V> {
  private final int numBuckets;
  ArrayList<LinkedList<K>> BucketArray;

  public LinkedHashTable() {
    this.numBuckets = 10;
    this.BucketArray = new ArrayList<>(numBuckets);
    for (int i = 0; i < numBuckets; i++) {
      this.BucketArray.add(null);
    }
  }

  private int getBucketIndex(K key) {
    int hashCode = Math.abs(key.hashCode());
    int index = hashCode % numBuckets;
    return index;
  }

  public V get(K key) {
    int index = this.getBucketIndex(key);
    LinkedList<K> list = this.BucketArray.get(index);
    if (list == null)
      return null;
    MapNode<K, V> MapNode = (MapNode<K, V>) list.search(key);
    return (MapNode == null) ? null : MapNode.getValue();
  }

  public void add(K key, V value) {
    int index = this.getBucketIndex(key);
    LinkedList<K> list = this.BucketArray.get(index);
    if (list == null) {
      list = new LinkedList<>();
      this.BucketArray.set(index, list);
    }
    MapNode<K, V> MapNode = (MapNode<K, V>) list.search(key);
    if (MapNode == null) {
      MapNode = new MapNode<>(key, value);
      list.append(MapNode);
    } else {
      MapNode.setValue(value);
    }
  }

  // print hash table
  public void print() {
    for (LinkedList<K> linkedlist : BucketArray) {
      if(linkedlist!=null){
      linkedlist.printMapNodes();
      }
    }
  }

}