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
    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        calculateDepth(root);
        return maxDiameter;
    }

    public int calculateDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int calculateLeft = calculateDepth(root.left);
        int calculateRight = calculateDepth(root.right);

        maxDiameter = Math.max(maxDiameter, calculateLeft + calculateRight);

        return Math.max(calculateLeft, calculateRight) + 1;
    }
}
