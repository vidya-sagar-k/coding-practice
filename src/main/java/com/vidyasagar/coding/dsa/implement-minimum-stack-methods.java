// https://leetcode.com/problems/min-stack
class MinStack {
    Stack<Integer> mainStack;
    Stack<Integer> minStack;
    public MinStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        mainStack.push(val);
        if (minStack.isEmpty()) {
            minStack.push(val);
        } else {
            int minEle = Math.min(val, minStack.peek());
            minStack.push(minEle);
        }
    }
    
    public void pop() {
        minStack.pop();
        mainStack.pop();
    }
    
    public int top() {
        return mainStack.peek();
        
    }
    
    public int getMin() {
        return minStack.peek();
        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
