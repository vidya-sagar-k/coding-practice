package com.vidyasagar.coding.cacheV1;

import java.util.HashMap;
import java.util.Optional;


public class CacheImplamentation<K,V> implements Cache<K,V>  {
  private HashMap<K,V> cacheMap;
  private EvictionStrategy evictionStrategy;
  private final int CACHE_SIZE;

  public CacheImplamentation(EvictionStrategy evictionStrategy, int capacity) {
    this.CACHE_SIZE = capacity;
    this.evictionStrategy = evictionStrategy;
    this.cacheMap = new HashMap<>();
  }

  @Override
  public boolean set(K key, V value) {
    if (this.cacheMap.containsKey(key)) {
      // set the value
      this.cacheMap.put(key, value);

    }
    else if (this.cacheMap.size() == this.CACHE_SIZE) {
      // need to getEvictionCandidateKey
      K keyToEvict = (K)evictionStrategy.getEvictionCandidateKey();
      this.cacheMap.remove(keyToEvict);
      this.cacheMap.put(key, value);
    }
    this.evictionStrategy.put(key, value);
    return true;
  }

  @Override
  public Optional<V> get(K key) {

    if (this.cacheMap.containsKey(key)) {
      // set the value
      this.evictionStrategy.access(key);
      return Optional.of(this.cacheMap.get(key));

    }

    return Optional.empty();
  }

  @Override
  public int getSize() {
    return this.cacheMap.size();
  }

  @Override
  public boolean isEmpty() {
    return this.cacheMap.isEmpty();
  }

  @Override
  public void clear() {
    this.evictionStrategy.clear();
    this.cacheMap.clear();
  }
}
