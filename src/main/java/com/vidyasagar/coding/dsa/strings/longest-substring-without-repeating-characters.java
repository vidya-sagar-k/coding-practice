//https://leetcode.com/problems/longest-substring-without-repeating-characters/?envType=company&envId=microsoft&favoriteSlug=microsoft-thirty-days
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n= s.length();


        if (n<=1) return n;

        HashSet<Character> hs = new HashSet<>();

        hs.add(s.charAt(0));
        int i = 1, j= 0;
        int mxCount = 0;
        while(i<n && j<= i) {
            if (!hs.contains(s.charAt(i))) {
                // happy case
                hs.add(s.charAt(i));

            } else {
                // remove jth element, till same char is removed
                while (j<i && s.charAt(j) != s.charAt(i)) {
                    hs.remove(s.charAt(j));
                    j++;
                }
                j++;

            }
            
            i++;

            mxCount = Math.max(mxCount, hs.size());
        }

        return mxCount;
        
    }
}
