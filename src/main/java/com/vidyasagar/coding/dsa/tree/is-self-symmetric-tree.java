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
  //https://leetcode.com/problems/symmetric-tree/
        public boolean isSymmetricTree(TreeNode p, TreeNode q) {
        
        if(p == null && q == null) return true;
        if (p == null && q != null) return false;
        if (p != null && q == null) return false;

        // both non null 
        if (p.val != q.val) return false;
        return isSymmetricTree(p.left, q.right) && isSymmetricTree(p.right, q.left);
    }
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetricTree(root.left, root.right);
    }
}
