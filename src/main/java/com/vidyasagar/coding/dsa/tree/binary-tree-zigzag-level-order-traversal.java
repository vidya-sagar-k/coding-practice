//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result =  new ArrayList<>();
        if (root == null) return result;

        LinkedList<Integer> currentLevel = new LinkedList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        boolean reverse = false;
        while(!q.isEmpty()) {
            TreeNode node = q.remove();
            if (node == null) {
                // last node of this level
                    result.add(currentLevel);
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                    currentLevel = new LinkedList<>();
                    reverse = !reverse;
                }
            } else {
                if (reverse)
                    currentLevel.addFirst(node.val);
                else 
                    currentLevel.addLast(node.val);
                if (node.left != null) { q.add(node.left);}
                if (node.right != null) { q.add(node.right);}
            }
        }

        

        return result;
    }
}
