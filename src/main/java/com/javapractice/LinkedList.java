package com.javapractice;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LinkedList<K> {
 
  protected INode<K> head;
  private static final Logger log = LogManager.getLogger(App.class);

  public INode<K> getHead() {
    return head;
  }
  public void setHead(INode<K> head) {
    this.head = head;
  }

  //check if list is empty
  public boolean isEmpty() {
    if (head == null) {//if head is null list is size 0
      return true;
    }
    return false;
  }
  //returns size of the linked list
  public int getSize() {
    int size = 0;
    INode<K> temp = head;
    while (temp != null) {
      temp = temp.getNext();
      size++;
    }
    return size;
  }
  //add new item to list in the beginning
  public void add(INode<K> newNode) {

    if (this.isEmpty()) {//check if list is empty,then create head=newnode
      this.head = newNode;
      return;
    }
    newNode.setNext(head);//update head as the new node
    head = newNode;
  }
  //append item to the end
  public void append(INode<K> newNode) {

    if (this.isEmpty()) {
      this.head = newNode;
      return;
    }
    INode<K> temp = head;
    //find end of linked list then append new node to last node
    while (temp.getNext() != null) {
      temp = temp.getNext();
    }
    temp.setNext(newNode);
  }
   //delete first node
  public Object pop() {
    if (isEmpty()) {
      return -1;
    }
    INode<K> temp = head;
    head = head.getNext();
    temp.setNext(null);
    return  temp.getKey();
  }
  //delete last node
  public int popLast() {
    INode<K> temp = head;
    if (isEmpty()) {
      return -1;
    }
    if (temp.getNext() == null) {
      head = null;
      return (int) temp.getKey();
    }
    while (temp.getNext().getNext() != null) {
      temp = temp.getNext();
    }
    int deletedItem = (int) temp.getNext().getKey();
    temp.setNext(null);
    return deletedItem;
  }
  //deleted node after a given node
  public boolean delete(K itemToDelete){
    INode<K> foundNode = this.search(itemToDelete);
    log.info("deleting item "+itemToDelete );
    INode<K> firstNode=null;
    INode<K> secondNode=head;
    // System.out.println(foundNode);
    //search the node if found then change linkages of previous and next node
    if(foundNode!=null){
      while (secondNode!=null&&!secondNode.getKey().equals(foundNode.getKey())) {
        firstNode = secondNode;
        secondNode = secondNode.getNext();
      }  
      firstNode.setNext(secondNode.getNext());
      secondNode.setNext(null);
      return true;
    }
    
    return false;

  }


  //search the item in linked list
  public INode<K> search(K item) {
    INode<K> temp = head;
    if (this.isEmpty())
      return null;
    while (temp != null) {
      // log.info(temp.getKey());
      if (temp.getKey().equals(item)) {
        return temp;
      }
      temp = temp.getNext();
    }
    return null;
  }

   //print the linked list
  public void printMapNodes() {
    if (this.isEmpty()) {
      log.info("List is empty!");
    }
    INode<K> temp = head;
    while (temp != null) {
      StringBuilder MapNodeString = new StringBuilder();
      String key=(String)temp.getKey();
      int value=(int)((MapNode)temp).getValue();
        MapNodeString.append(key)
                .append(" | ").append(value);
      log.info(MapNodeString);
      temp = temp.getNext();
    }
  }
}
