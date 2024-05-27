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
  // https://leetcode.com/problems/binary-tree-level-order-traversal/
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> q =new LinkedList<>();
        q.add(root);
        q.add(null);
        List<Integer> currentLevel = new ArrayList<>();
        while(!q.isEmpty()) {
            TreeNode currentNode = q.remove();
            if (currentNode == null) {
                // last node was processed of this level
                if (q.isEmpty()) {
                    break;
                } else {
                    // add this marker
                    q.add(null);
                    result.add(currentLevel);
                    currentLevel = new ArrayList<>();
                    continue;
                }
            }
            currentLevel.add(currentNode.val);
            if(currentNode.left != null){q.add(currentNode.left);}
            if(currentNode.right != null){q.add(currentNode.right);}
        }
        result.add(currentLevel);
        //if (!currentLevel.isEmpty()){result.add(currentLevel);}
        
        return result;
    }
}
