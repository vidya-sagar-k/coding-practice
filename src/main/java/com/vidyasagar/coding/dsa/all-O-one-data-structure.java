https://leetcode.com/problems/all-oone-data-structure/
class AllOne {
    HashMap<String, Node> hm;
    TreeMap<Integer, Node> tm;

    public AllOne() {
        hm = new HashMap<>();
        tm = new TreeMap<>();
    }
    
    public void inc(String key) {
        if (!hm.containsKey(key)) {
            Node node = new Node(key);
            hm.put(key, node);
        }

        // TreeMap remove from prev  pos, 
        Node node = hm.get(key);
        if (node.count > 0) {
            removeFromTreeMap(node);
        }

        // add in new position
        node.count++;
        addInTreeMap(node);
    }
    
    public void dec(String key) {
        Node node = hm.get(key);

        // TreeMap remove from prev  pos,         
        removeFromTreeMap(node);
        

        // add in new position
        node.count--;
        if (node.count == 0) {
            // remove
            hm.remove(key);
            return;
        }
        addInTreeMap(node);

        
    }
    
    public String getMaxKey() {
        if (tm.isEmpty()) return "";

        Map.Entry<Integer, Node> lastEntry = tm.lastEntry();
        return lastEntry.getValue().next.key;
        
    }
    
    public String getMinKey() {
        if (tm.isEmpty()) return "";

        Map.Entry<Integer, Node> firstEntry = tm.firstEntry();
        return firstEntry.getValue().next.key;
        
    }

    private void removeFromTreeMap(Node node) {
        Node dllHead = tm.get(node.count);
            
        node.prev.next = node.next;
        node.next.prev = node.prev;

        if (dllHead.next.next == null) {
            tm.remove(node.count);
        }
    }

    private void addInTreeMap(Node node) {
        if (!tm.containsKey(node.count)) {
            // create entry with LL
            Node head = new Node("HEAD");
            Node tail = new Node("TAIL");
            head.next = tail;
            tail.prev = head;
            tm.put(node.count, head);
        } 
        Node head = tm.get(node.count);
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node; 
    }
}

class Node {
    String key;
    Node next;
    Node prev;
    int count;

    Node(String key) {
        this.key = key;
        this.count = 0;
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
