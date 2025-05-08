// https://leetcode.com/problems/subsets/?envType=company&envId=google&favoriteSlug=google-thirty-days
class Solution {
    private void addSubSets(int[] nums, List<List<Integer>> result, List<Integer> subSet, int index, int n) {
        if (index>=n) {
            result.add(new ArrayList(subSet));
            return;
        }

        // take
        subSet.add(nums[index]);
        addSubSets(nums, result, subSet, index+1, n);

        subSet.remove(subSet.size() - 1);
        addSubSets(nums, result, subSet, index+1, n);
    }
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        if (n==0) return result;

        List<Integer> subSet = new ArrayList<>();
        addSubSets(nums, result, subSet, 0, n);

        return result;
        
    }
}
