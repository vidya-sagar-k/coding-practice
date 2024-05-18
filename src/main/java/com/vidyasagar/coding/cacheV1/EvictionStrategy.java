package com.vidyasagar.coding.cacheV1;

public interface EvictionStrategy<K,V> {
  K getEvictionCandidateKey();
  void put(K key, V value);
  void access(K key);
  void clear();
}
