package com.vidyasagar.coding;

import com.vidyasagar.coding.cacheV1.CacheImplamentation;
import com.vidyasagar.coding.cacheV1.LRUEvictionStrategy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CodingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodingApplication.class, args);
		System.out.println("Started application......");
		runTrie();
		lruCache();
	}

	public static void runTrie() {
		Trie trie = new Trie();
		trie.insert("tea");
		trie.insert("ten");
		System.out.println(trie.search("ten"));
		System.out.println(trie.search("tep"));
		System.out.println(trie.search("tea"));
		System.out.println(trie.search("te"));
		trie.insert("tep");
		System.out.println(trie.search("tep"));
	}

	public static void lruCache() {
		CacheImplamentation<String, Integer> cache = new CacheImplamentation<String, Integer>(new LRUEvictionStrategy <>(), 4);
		cache.set("outlet_id", 10);
		cache.set("pin", 5566);
		System.out.println(cache.get("outlet_id"));
		System.out.println(cache.get("random"));
		cache.set("a", 1);
		cache.set("b", 2);
		cache.set("c", 3);
	}

}
