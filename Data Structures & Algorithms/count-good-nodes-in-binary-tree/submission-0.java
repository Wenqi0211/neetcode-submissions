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
    int result = 0;
    public int goodNodes(TreeNode root) {
        dfs(root, root.val);
        return result;
    }
    private void dfs(TreeNode node, int MaxSoFar) {
        if (node == null) {
            return;
        }
        
        if (node.val >= MaxSoFar) {
            result++;
        } 
        MaxSoFar = Math.max(node.val, MaxSoFar);
        dfs(node.left, MaxSoFar);
        dfs(node.right, MaxSoFar);
    }
}
