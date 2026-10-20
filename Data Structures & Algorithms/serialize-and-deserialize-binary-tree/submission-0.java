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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> result = new ArrayList<>();
        dfsSrrialize(root, result);
        return String.join(",", result); //list -> string
    }
    private void dfsSrrialize(TreeNode node, List<String> result) {
        if (node == null) {
            result.add("null");
            return;
        }
        result.add(String.valueOf(node.val)); //int -> string
        dfsSrrialize(node.left, result);
        dfsSrrialize(node.right, result);
    }
    // Decodes your encoded data to tree.
    int index = 0;
    String[] tokens;
    public TreeNode deserialize(String data) {
        tokens = data.split(",");
        return dfsDeserialize();
    }
    private TreeNode dfsDeserialize() {
        String token = tokens[index];
        index++;
        if (token.equals("null")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(token));//string -> int
        node.left = dfsDeserialize();
        node.right = dfsDeserialize();
        return node;
    }
}
