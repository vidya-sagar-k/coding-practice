class Solution {
  // https://leetcode.com/problems/maximum-subarray/description/
    public int maxSubArray(int[] nums) {
        // see if prev sum is beneficial
        int n = nums.length;

        if (n == 0) return 0;

        int maxSum = nums[0];
        int prevSum = nums[0];
        for (int i = 1;i<n; i++) {
            if (prevSum + nums[i] > nums[i]){
                prevSum = prevSum + nums[i];
            } else {
                // self
                prevSum = nums[i];
            }
            maxSum = Math.max(maxSum, prevSum);
        }

        return maxSum;
    }
}
