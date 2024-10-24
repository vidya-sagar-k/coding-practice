// https://leetcode.com/problems/trapping-rain-water/
class Solution {

    // https://www.youtube.com/watch?v=1_5VuquLbXg
    // 2 pointer
    public int trapWithNoExtraSpace(int[] height) {
        int lMax = 0, rMax = 0, res = 0;
        int l = 0, r = height.length - 1;


        while(l<r) {
            if (height[l]<= height[r]){
                if (height[l] <= lMax) {
                    res += lMax - height[l];
                } else {
                    lMax = height[l];
                }
                l++;
            } else {
                if (height[r] <= rMax) {
                    res += rMax - height[r];
                } else {
                    rMax = height[r];
                }
                r--;

            }
        }

        return res;
    }
    
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
