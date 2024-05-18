package com.vidyasagar.coding;


public class Trie {
  private Node root;
  public Trie() {
    this.root = new Node("");
  }
  void insert(String word) {
    Node currentNode = this.root;

    for (int i = 0; i<word.length(); i++) {
      String prefix = currentNode.getPrefix();
      char ch = word.charAt(i);
      Node[] childNodes =  currentNode.getChildNodes();
      if (childNodes[ch - 'a'] != null) {
        // System.out.println("node FOUND for prefix : " + prefix + " and letter : " + ch);

        currentNode = currentNode.getChildNodes()[ch - 'a'];

      } else {
        // System.out.println("node not found for prefix : " + prefix + " and letter : " + ch);

        Node node = new Node(prefix + ch);
        childNodes[ch - 'a'] = node;
        currentNode = node;
      }

    }
    currentNode.setWordCount(currentNode.getWordCount() + 1);
    System.out.println("inserted : " + word);
  }

  boolean search(String word) {
    Node currentNode = this.root;

    for (int i = 0; i<word.length(); i++) {
      String prefix = currentNode.getPrefix();
      char ch = word.charAt(i);
      Node[] childNodes =  currentNode.getChildNodes();
      if (childNodes[ch - 'a'] != null) {
        // System.out.println("node FOUND for prefix : " + prefix + " and letter : " + ch);

        currentNode = currentNode.getChildNodes()[ch - 'a'];

      } else {
        // System.out.println("word NOT found : " + word);

        return false;
      }

    }
    if (currentNode.getWordCount() > 0) {
      System.out.println("found : " + word);
      return true;
    }

    System.out.println("word NOT found : " + word);
    return false;
  }


}

class Node {
  private int wordCount;
  private String prefix;
  private Node[] childNodes;

  public Node(String prefix) {
    this.wordCount = 0;
    this.prefix = prefix;
    childNodes = new Node[26];
  }

  public Node[] getChildNodes() {
    return this.childNodes;
  }
  public String getPrefix() {
    return this.prefix;
  }

  public int getWordCount() {
    return this.wordCount;
  }

  public void setWordCount(int c) {
    this.wordCount = c;
  }
}
