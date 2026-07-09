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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // base case: able to create a leaf node at this empty spot
        if (root == null) {
            TreeNode leaf = new TreeNode(val);
            return leaf;
        }

        // traverse the right subtree
        if (val > root.val) {
            root.right = insertIntoBST(root.right, val);
        } else { // traverse the left subtree
            root.left = insertIntoBST(root.left, val);
        }

        return root;
    }
}