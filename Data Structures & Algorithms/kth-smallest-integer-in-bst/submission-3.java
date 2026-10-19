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
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return result;
    }
    private boolean dfs(TreeNode node, int k) {
        if (node == null) {
            return false;
        }
        boolean foundLeft = dfs(node.left, k);
        if (foundLeft == true) {
            return true;
        }
        count++;
        if (count == k) {
            result = node.val;
            return true;
        }
        boolean foundRight = dfs(node.right, k);
        if (foundRight == true) {
            return true;
        }
        return false;
    }
}
