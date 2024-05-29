//  https://leetcode.com/problems/design-a-text-editor/
class DoublyLinkedListNode {
    char val;
    DoublyLinkedListNode next;
    DoublyLinkedListNode prev;
    public DoublyLinkedListNode(char val) {
        this.val = val;
    }
}

class TextEditor {
    DoublyLinkedListNode node;
    DoublyLinkedListNode head;
    DoublyLinkedListNode tail;
    DoublyLinkedListNode curserNode;

    public TextEditor() {
        head = new DoublyLinkedListNode('-');
        tail = new DoublyLinkedListNode('-');
        head.next = tail;
        tail.prev=head;
        curserNode = head;
    }
    
    public void addText(String text) {
        // add node for each char
        int n = text.length();
        for(int i = 0; i<n; i++) {
            DoublyLinkedListNode node = new DoublyLinkedListNode(text.charAt(i));
            node.next = curserNode.next;
            node.prev = curserNode;
            curserNode.next.prev = node;
            curserNode.next = node;

            curserNode = node;
        }
    }
    
    public int deleteText(int k) {
        // delete curserNode
        if (curserNode == head) {
            return 0;
        }
        
        int deletedChars = 0;
        while(k-- > 0 && curserNode != head) {
            curserNode.prev.next = curserNode.next;
            curserNode.next.prev = curserNode.prev;
            curserNode = curserNode.prev;
            deletedChars++;
        }

        return deletedChars;
    }
    
    public String cursorLeft(int k) {
        while(k> 0 && curserNode != head) {
            curserNode = curserNode.prev;
            k--;
        }
        if (curserNode == head) return "";

        return getPrevString(curserNode);
    }
    
    public String cursorRight(int k) {
        while(k-- > 0 && curserNode.next != tail) {
            curserNode = curserNode.next;
        }

        return getPrevString(curserNode);
    }

    public String getPrevString(DoublyLinkedListNode curserNode) {
        if (curserNode == head) return "";
        int k = 10;
        DoublyLinkedListNode start = curserNode;
        while(k > 0 && start != head) {
            start = start.prev;
            k--;
        }
        start = start.next;
        StringBuilder sb = new StringBuilder();
        while(start != curserNode) {
            
            sb.append(start.val);
            start = start.next;
        }
        sb.append(curserNode.val);

        return sb.toString();
    }
}

/**
 * Your TextEditor object will be instantiated and called as such:
 * TextEditor obj = new TextEditor();
 * obj.addText(text);
 * int param_2 = obj.deleteText(k);
 * String param_3 = obj.cursorLeft(k);
 * String param_4 = obj.cursorRight(k);
 */
