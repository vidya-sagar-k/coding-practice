//567.  https://leetcode.com/problems/permutation-in-string/
class Solution {
    public boolean sameFrequence(int[] a, int[] b) {
        for (int i = 0; i<26; i++) {
            if (a[i] != b[i]) return false;
        }

        return true;
    }
    
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();

        if (n1 == 0) return true;

        if (n2<n1) {return false;}

        int[] s1Chars = new int[26];
        int[] windowChars = new int[26];

        for (char c : s1.toCharArray()) {
            s1Chars[c - 'a']++;
        }

        // sliding window
        int i = 0;
        for (; i<n1; i++) {
            windowChars[s2.charAt(i) - 'a']++;
        }
        if (sameFrequence(s1Chars, windowChars)) return true;
        int j = 0;

        while (i<n2) {
            windowChars[s2.charAt(i) - 'a']++;
            windowChars[s2.charAt(j) - 'a']--;
            if (sameFrequence(s1Chars, windowChars)) return true;
            i++;
            j++;
        }

        return false;


    }
}
