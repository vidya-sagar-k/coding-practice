package com.vidyasagar.coding.cacheV1;

import java.util.LinkedList;

public class LRUEvictionStrategy<K,V> implements EvictionStrategy<K,V> {
  private LinkedList<K> doublyLinkedList;

  public LRUEvictionStrategy() {
    this.doublyLinkedList = new LinkedList<>();
  }

  @Override
  public K getEvictionCandidateKey() {
    // Based on Doubly LinkedList, return the last node's key
    // also remove this from local queue.
    return null;
  }

  @Override
  public void put(K key, V value) {
    // add the new node at the head of doubly LL
  }

  @Override
  public void access(K key) {
    //move the node at the head of LL

  }

  @Override
  public void clear() {
    // clear the LL

  }
}

