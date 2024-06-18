// https://leetcode.com/problems/construct-the-lexicographically-largest-valid-sequence/
class Solution {
    public int[] constructDistancedSequence(int n) {
        boolean[] visited = new boolean[n+1];
        int[] ans  = new int[2*n-1];

        populateNumber(0, ans, visited, n);
        return ans;
    }

    private boolean populateNumber(int index, int[] ans, boolean[] visited, int n) {
        if (index == ans.length) {
            return true;
        }

        if (ans[index] != 0) {
            return populateNumber(index+1, ans, visited, n);
        }

        for (int i = n; i>= 1; i--) {
            if (visited[i]) continue;
            visited[i] = true;
            ans[index] = i;
            if (i == 1) {
                if (populateNumber(index+1, ans, visited, n)) return true;
            } else if (index + i < ans.length && ans[index + i ] == 0) {
                ans[index + i ] = i;
                if (populateNumber(index+1, ans, visited, n)) return true;
                ans[index + i ] = 0;
            }
            // revert/backtrack
            ans[index] = 0;
            
            visited[i] = false;
        }
        return false;
    }
}
