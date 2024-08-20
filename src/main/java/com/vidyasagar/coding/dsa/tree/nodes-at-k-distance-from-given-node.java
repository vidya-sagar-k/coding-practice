//https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
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
    private void distanceKRecursive(TreeNode root, int k, List<Integer> result, 
    HashMap<TreeNode, Boolean> visited, HashMap<TreeNode, TreeNode> parentMap) {
        if (root == null || visited.containsKey(root)) return;
        visited.put(root, true);
        if (k == 0) {
            result.add(root.val);
            return;
        } 
        
        distanceKRecursive(root.left, k-1, result, visited, parentMap);
        distanceKRecursive(root.right, k-1, result, visited, parentMap);
        distanceKRecursive(parentMap.getOrDefault(root, null), k-1, result, visited, parentMap);
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if (k == 0) return Arrays.asList(target.val);
        HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        while(!q.isEmpty()) {
            TreeNode current = q.poll();
            if (current.left != null) {
                parentMap.put(current.left, current);
                q.add(current.left);
            }
            if (current.right != null) {
                parentMap.put(current.right, current);
                q.add(current.right);
            }
        }

        List<Integer> result = new ArrayList<>();
        HashMap<TreeNode, Boolean> visited = new HashMap<>();


        distanceKRecursive(target, k, result, visited, parentMap);

        return result;
        
    }
}
