class Solution {
// https://leetcode.com/problems/longest-palindromic-substring/
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n<=1) return s;
        int[][] palindrom = new int[n][n];
        for (int[] row : palindrom) {
            Arrays.fill(row, 0);
        }
        for (int i = 0; i<n; i++) {
            palindrom[i][i] = 1;
        }

        int startIndex = 0, endIndex = 0;

        for (int k = 2; k<=n; k++){
            int i = 0, j = k-1;
            while(j<n) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (i+1 >= j-1 || palindrom[i+1][j-1] == 1) {
                        palindrom[i][j] = 1;
                        startIndex = i;
                        endIndex = j;
                    }
                }

                i++;
                j++;
            }
        }
        
        return s.substring(startIndex, endIndex+1);
        
    } 
}
