// https://leetcode.com/problems/task-scheduler/
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for(char c : tasks) {
            count[c-'A']++;
        }

        Arrays.sort(count);
        int maxCount = count[25];
        int slots = (maxCount - 1) * n;

        for (int i = 24; i>=0; i--) {
            slots -= Math.min(count[i], maxCount-1);
        }

        if (slots > 0) return slots + tasks.length;
        else return tasks.length; 

    }
}
