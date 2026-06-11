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
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean dfs(TreeNode node, long small, long big) {
        if (node == null) {
            return true;
        }

        if (node.val <= small || node.val >= big) {
            return false;
        }

        boolean left = dfs(node.left, small, node.val);
        boolean right = dfs(node.right, node.val, big);
        return left && right;
    }
}