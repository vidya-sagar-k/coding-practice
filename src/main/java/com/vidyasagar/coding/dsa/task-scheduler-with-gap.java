// https://leetcode.com/problems/task-scheduler/
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }

        Arrays.sort(freq);
        int batchCount = freq[25];
        int vacantSlots = (batchCount-1) * n;

        for (int i = 0; i<25; i++) {
            vacantSlots -= Math.min(batchCount-1, freq[i]);
        }

        return vacantSlots > 0 ? vacantSlots + tasks.length : tasks.length;

    }
}
