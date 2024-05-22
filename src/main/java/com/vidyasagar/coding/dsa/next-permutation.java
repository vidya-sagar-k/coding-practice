class Solution {
  // https://leetcode.com/problems/next-permutation/
    private void reverse(int[] nums, int start) {
        int i = start;
        int j = nums.length - 1;
        while(i<j) {
            swap(nums, i, j);
            i++;
            j--;
        }

    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if (n<=1) return;

        int i = n-1;
        while(i>0 && nums[i-1]>=nums[i]) {
            i--;
        }
        if(i == 0) {
            // already highest permutation, just reverse the number
            reverse(nums, 0);
            return;
        }
        int index = i-1;
        int index2;

        for (i = n-1; i>index; i--) {
            if (nums[i]>nums[index]){
                index2 = i;
                swap(nums, index, index2);
                break;
            }
        }

        
        reverse(nums, index+1);
    }
}
