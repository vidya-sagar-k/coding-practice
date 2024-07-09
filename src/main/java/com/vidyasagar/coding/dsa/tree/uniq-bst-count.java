// https://leetcode.com/problems/unique-binary-search-trees/
class Solution {
    private int treeCount(int n, int[] dp) {
        if (n<=1) return 1;

        if (dp[n] > 0) return dp[n];
        int total = 0;
        for(int i = 1; i<=n; i++) {
            total += treeCount(i-1, dp) * treeCount(n-i, dp);
        }

        dp[n] = total;
        return total;

    }
    public int numTrees(int n) {
        if (n<=1) return 1;
        int[] dp = new int[n+1];

        return treeCount(n, dp);
    }
}
