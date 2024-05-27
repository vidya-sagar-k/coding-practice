/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
  // https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
    public boolean findNode(TreeNode root, TreeNode k) {
        if (root == null) return false;
        if (root == k) return true;
        return findNode(root.left, k) || findNode(root.right, k);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q) {
            return root;
        }

        boolean pLeft = findNode(root.left, p);
        boolean qRight = findNode(root.right, q);
        if (pLeft && qRight) return root;

        boolean pRight = findNode(root.right, p);
        boolean qLeft = findNode(root.left, q);
        if (pRight && qLeft) return root;
        // both on one side

        if (pLeft && qLeft) return lowestCommonAncestor(root.left, p, q);
        else return lowestCommonAncestor(root.right, p, q);
    }
}
