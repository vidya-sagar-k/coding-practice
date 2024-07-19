// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBSTRecursive(int[] nums, int i, int j) { 
        if (i>j) return null;
        // if (i == j) {
        //     // one node
        //     return new TreeNode(nums[i]);
        // }
        // if (i == j-1) {
        //     TreeNode root = new TreeNode(nums[i]);
        //     root.right = new TreeNode(nums[j]);
        //     return root;
        // }

        int mid = i + (j-i)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBSTRecursive(nums, i, mid-1);
        root.right = sortedArrayToBSTRecursive(nums, mid+1, j);

        return root;
        
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBSTRecursive(nums, 0, nums.length-1);
    }
}
