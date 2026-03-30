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
    public TreeNode invertTree(TreeNode root) {
        // Run DFS and do a left/right swap at every node
        if (root == null) {
            return root;
        }

        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;

        TreeNode leftHalf = invertTree(root.left);
        TreeNode rightHalf = invertTree(root.right);

        return root;
    }
}
