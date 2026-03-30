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

    public boolean dfs(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        // if within the boundaries, run dfs on left and right again
        if (root.val <= min || root.val >= max) {
            return false;
        }
        // if go left, current node value becomes the max
        boolean goLeft = dfs(root.left, min, root.val);
        // if go right, current node value becomes the min
        boolean goRight = dfs(root.right, root.val, max);

        return goLeft && goRight;
    }
}
