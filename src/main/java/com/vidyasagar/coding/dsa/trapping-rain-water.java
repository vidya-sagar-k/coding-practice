// https://leetcode.com/problems/trapping-rain-water/
class Solution {
    public int trap(int[] height) {
        int n = height.length;

        if (n<3) return 0;

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        int mx = 0;
        for (int i = 0 ; i< n; i++) {
            mx = Math.max(mx, height[i]);
            leftMax[i] = mx;
        }

        mx = 0;
        for (int i = n-1 ; i>=0; i--) {
            mx = Math.max(mx, height[i]);
            rightMax[i] = mx;
        }

        int waterTrapped = 0;
        for (int i = 1 ; i< n-1; i++) {
            int minHeight = Math.min(leftMax[i-1], rightMax[i+1]);
            if (minHeight > height[i]) {
                waterTrapped += (minHeight - height[i]);
            }
        }

        return waterTrapped;
        
    }
}
