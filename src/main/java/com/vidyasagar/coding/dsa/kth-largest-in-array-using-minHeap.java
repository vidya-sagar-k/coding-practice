// https://leetcode.com/problems/kth-largest-element-in-an-array
class Solution {
    public int findKthLargest(int[] nums, int k) {
        // min Heap
        PriorityQueue<Integer> mh = new PriorityQueue<>();
        
        for (int num : nums) {
            mh.add(num);
            if (mh.size() >  k) {
                mh.remove();
            }
        }
        // now minHeap has only K max elements.. head is at Kth Largest
        return mh.peek();
        
    }
}
