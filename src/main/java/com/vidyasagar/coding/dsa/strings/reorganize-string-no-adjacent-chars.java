// https://leetcode.com/problems/reorganize-string/
class CharCount implements Comparable<CharCount>{
    char c;
    int count;
    CharCount(char c, int count) {
        this.c = c;
        this.count = count;
    }

    public int compareTo(CharCount other) {
        return other.count - this.count;
    }
}

class Solution {
    public String reorganizeString(String s) {
        int n = s.length();
        if (n<=1) return s;

        int[] count = new int[26];
        for(char c: s.toCharArray()) {
            count[c - 'a']++;
        }

        PriorityQueue<CharCount> pq = new PriorityQueue<>();

        for (int i = 0; i<=25; i++) {
            if (count[i]>0) {
                pq.add(new CharCount((char) (i + 'a'), count[i]));
            }
        }

        StringBuilder sb = new StringBuilder();
        char lastChar = ' ';
        while(!pq.isEmpty()) {
            CharCount firstCC = pq.poll();
            if (firstCC.c != lastChar) {
                sb.append(firstCC.c);
                firstCC.count -= 1;
                if (firstCC.count > 0) {
                    pq.add(firstCC);
                }
                lastChar = firstCC.c;
                continue;
            } else {
                // same, fetch next one
                if (pq.isEmpty()) return ""; // not possible
                CharCount secondCC = pq.poll();
                sb.append(secondCC.c);
                lastChar = secondCC.c;
                secondCC.count -= 1;
                if (secondCC.count > 0) {
                    pq.add(secondCC);
                }
                pq.add(firstCC);
            }
        }
        
        return sb.toString();
    }
}
