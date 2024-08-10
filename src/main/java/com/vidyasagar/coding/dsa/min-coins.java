// https://leetcode.com/problems/coin-change/
class Solution {
    public int coinChangeDp(int[] coins, int amount, HashMap<Integer, Integer> hm ) {
        if (amount < 0) return -1;
        else if (amount == 0) return 0;

        if (hm.containsKey(amount)) return hm.get(amount);
        int minCount = Integer.MAX_VALUE;
        int count = -1;
        for(int coin : coins) {
            if (coin > amount) continue;
            count = coinChangeDp(coins, amount - coin, hm);
            if (count >=0) {
                minCount = Math.min(minCount, count);
            }
        }
        if (minCount != Integer.MAX_VALUE) {
            hm.put(amount, minCount+1);
            return minCount+1;
        }

        hm.put(amount, -1);
        return -1;
    }
        
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        return coinChangeDp(coins, amount, hm);
    }
}
