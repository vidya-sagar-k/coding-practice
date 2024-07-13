// https://leetcode.com/problems/edit-distance/
class Solution {
    public int minDistanceDp(String word1, String word2, int i, int j, int[][] dp) {
        int n1 = word1.length();
        int n2 = word2.length();

        if (i == n1 && j == n2) {
            return 0;
        } else if (i==n1) {
            return n2-j;
        } else  if (j == n2) {
            return n1- i;
        }

        if (dp[i][j] != -1) return dp[i][j];

        // both within range
        if (word1.charAt(i) != word2.charAt(j)) {
            // replace one.. and move both
            // or delete from word1
            // or delete from word2
            int rep = minDistanceDp(word1, word2, i+1, j+1, dp);
            int del = Math.min(minDistanceDp(word1, word2, i+1, j, dp), minDistanceDp(word1, word2, i, j+1, dp));
            dp[i][j] = 1 + Math.min(rep, del);

        } else {
            // match
            dp[i][j] = minDistanceDp(word1, word2, i+1, j+1, dp);
        }

        return dp[i][j];

    }
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();

        if (n1 == 0) return n2;
        if (n2 == 0) return n1;

        int[][] dp = new int[n1][n2];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        return minDistanceDp(word1, word2, 0, 0, dp);
    }
}
