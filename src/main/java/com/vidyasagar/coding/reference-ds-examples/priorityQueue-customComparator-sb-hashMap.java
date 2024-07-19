//https://leetcode.com/problems/sort-characters-by-frequency/
class Solution {
    public String frequencySort(String s) {
        PriorityQueue<CharCount> mx = new PriorityQueue<>(new CharCountComparator());

        HashMap<Character, Integer> hm = new HashMap<>();

        for (char c : s.toCharArray()) {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }
        for (Character c : hm.keySet()) {
            mx.add(new CharCount(c, hm.get(c)));
        }
        

        StringBuilder sb = new StringBuilder();
        while(!mx.isEmpty()) {
            CharCount cc = mx.remove();
            while(cc.count-- > 0)
                sb.append(cc.c);

        }
        return sb.toString();
    }
}

class CharCount {
    char c;
    int count;

    CharCount(char c, int count) {
        this.c = c;
        this.count = count;
    }
}

class CharCountComparator implements Comparator<CharCount> {
    public int compare(CharCount a, CharCount b) {
        return b.count - a.count;
    }
}
