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
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    public int dfs(TreeNode root, int max) {
        // base case
        if (root == null) { // we have reached the end
            return 0;
        }

        int goodCount = 0;

        if (root.val >= max) { // found a good node
            goodCount++;
            max = Math.max(max, root.val);
        }

        goodCount += dfs(root.left, max);
        goodCount += dfs(root.right, max);

        return goodCount;
    }
}
