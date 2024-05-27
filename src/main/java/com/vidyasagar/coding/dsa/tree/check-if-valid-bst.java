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
  // https://leetcode.com/problems/validate-binary-search-tree/
    private TreeNode getPredecessor(TreeNode root) {
        if (root.left == null) return root; 
        TreeNode pred = root.left;
        while(pred.right != null) {
            pred = pred.right;
        }

        return pred;
    }

    private TreeNode getSuccessor(TreeNode root) {
        if (root.right == null) return root; 
        TreeNode succ = root.right;
        while(succ.left != null) {
            succ = succ.left;
        }

        return succ;
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (root.left != null  && root.left.val >= root.val) return false;
        if (root.right != null  && root.right.val <= root.val) return false;

        // root is OK
        TreeNode pred = getPredecessor(root);
        if (pred != root && pred.val >= root.val) return false;

        TreeNode succ = getSuccessor(root);
        if (succ != root && succ.val <= root.val) return false;

        return isValidBST(root.left) && isValidBST(root.right);
    }
}
