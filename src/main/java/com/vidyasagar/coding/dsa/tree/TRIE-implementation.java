// https://leetcode.com/problems/implement-trie-prefix-tree/
class Node {
    Node[] children;
    int wordCount;
    String prefix;
    public Node(String prefix) {
        this.prefix = prefix;
        children = new Node[26];
        wordCount = 0;
    }
}

class Trie {
    Node root;
    public Trie() {
        root = new Node("");
    }
    
    public void insert(String word) {
        Node currentNode = root;
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            sb.append(c);
            int index = c - 'a';
            if (currentNode.children[c - 'a'] == null) {
                Node node = new Node(sb.toString());
                currentNode.children[c - 'a']  = node;
            }

            currentNode = currentNode.children[c - 'a'];
            
        }

        currentNode.wordCount += 1;
        
    }
    
    public boolean search(String word) {
        Node currentNode = root;
        for (char c : word.toCharArray()) {
            if (currentNode.children[c - 'a'] == null) {
                return false;
            }

            currentNode = currentNode.children[c - 'a'];
            
        }

        return currentNode.wordCount > 0;
    }
    
    public boolean startsWith(String prefix) {
        Node currentNode = root;
        for (char c : prefix.toCharArray()) {
            if (currentNode.children[c - 'a'] == null) {
                return false;
            }

            currentNode = currentNode.children[c - 'a'];
            
        }

        return true;
        
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
