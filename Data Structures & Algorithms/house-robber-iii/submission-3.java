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
    public int rob(TreeNode root) {
        // base case: empty tree
        if (root == null) {
            return 0;
        }

        // run the helper method on the root
        // returns the two optimal final states for the entire tree
        int[] result = calculateMax(root);
        // select the greater of the two
        return Math.max(result[0], result[1]);
    }

    // helper method to determine the maximum amount of money whether or not 
    // the thief decides to rob the house [maxIfSkipped, maxIfRobbed]

    public int[] calculateMax(TreeNode root) {
        // base case: non-existent node
        if (root == null) {
            return new int[]{0, 0};
        }

        // perform a post-order traversal (left > right > root)
        int[] left = calculateMax(root.left);
        int[] right = calculateMax(root.right);

        // when the recursive call returns, we are met with two cases
        // case 1: skip the current house and take the max of both subtrees
        int skipCurrent = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        // case 2: rob the current house and skip the children nodes
        int robCurrent = root.val + left[0] + right[0];

        // return these two states to the parent
        return new int[]{skipCurrent, robCurrent};  
    }
}