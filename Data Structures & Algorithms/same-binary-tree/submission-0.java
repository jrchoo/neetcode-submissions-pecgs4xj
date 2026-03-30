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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // both are null
        if (p == null && q == null) {
            return true;
        }
        // only one is null
        if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        }
        // both not null
        if (p.val != q.val) {
            return false;
        }

        boolean checkLeft = isSameTree(p.left, q.left);
        boolean checkRight = isSameTree(p.right, q.right);

        return checkLeft && checkRight;
    }
}
