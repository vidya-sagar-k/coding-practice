package com.vidyasagar.coding.cacheV1;

import java.util.Optional;

public interface Cache<K,V> {
  boolean set(K key, V value);
  Optional<V> get(K key);
  int getSize();
  boolean isEmpty();
  void clear();
}
