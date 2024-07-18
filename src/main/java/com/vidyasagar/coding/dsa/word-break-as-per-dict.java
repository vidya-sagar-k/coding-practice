// https://leetcode.com/problems/word-break/
// https://leetcode.com/problems/word-break/solutions/3860456/100-dp-dfs-video-segmenting-a-string/
class Solution {
    public boolean wordBreak(String s, List<String> dict) {
        int mx = 0;
        for (String st : dict) {
            mx = Math.max(mx, st.length());
        }

        int n  = s.length();

        int[] dp = new int[n+1];
        dp[0] = 1;

        for (int i = 1; i<=n; i++) {
            for (int j = i-1; j>=0 && (i-j) <= mx; j--) {
                if (dp[j] == 1 && dict.contains(s.substring(j,i))) {
                    dp[i] = 1;
                }
            }
        }

        return dp[n] == 1;
        
    }
}
