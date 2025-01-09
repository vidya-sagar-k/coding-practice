// https://leetcode.com/problems/palindromic-substrings/
class Solution {
    public int countSubstrings(String s) {
        int n = s.length();

        int[][] dp = new int[n][n];
        for(int i = 0; i<n; i++) dp[i][i] = 1;
        int count = n;

        for (int k = 2; k<=n; k++) {
            for (int i= 0; i<=n-k; i++) {
                int j = i+k-1;
                if (s.charAt(i) == s.charAt(j)) {
                    if (i+1 >= j-1 || dp[i+1][j-1] == 1) {
                        count++;
                        dp[i][j] = 1;
                    }
                }
            }
        }

        return count;
    }
}
