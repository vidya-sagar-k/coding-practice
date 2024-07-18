// https://leetcode.com/problems/all-possible-full-binary-trees/

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
    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> result = new ArrayList<>();
        
        if (n==1) {
            result.add(new TreeNode(0));
            return result;
        }

        int left = 1; 
        while (left <= n-2) {

            List<TreeNode> leftSubTrees = allPossibleFBT(left);
            List<TreeNode> rightSubTrees = allPossibleFBT(n- left - 1);

            // for each comb, one tree

            for (TreeNode lst : leftSubTrees) {
                 for (TreeNode rst : rightSubTrees) {
                    TreeNode root = new TreeNode(0);
                    root.left = lst;
                    root.right = rst;
                    result.add(root);
                }
            }

            left += 2;
        }
        return result;
        
    }

    
}
