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
    int pre = 0;
    int[] preorder;
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return dfs(0, inorder.length - 1);
    }
    private TreeNode dfs(int l, int r) {
        if (l > r) {
            return null;
        }
        
        int preVal = preorder[pre];
        TreeNode root = new TreeNode(preVal);
        pre++;
        int mid = map.get(preVal);
        root.left = dfs(l, mid - 1);
        root.right = dfs(mid + 1, r);
        return root;
    }
}
