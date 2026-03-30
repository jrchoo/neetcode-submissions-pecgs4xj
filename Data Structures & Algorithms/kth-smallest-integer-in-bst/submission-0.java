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
    private int result = 0;
    private int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        inorderTraversal(root, k);
        return result;
    }

    public void inorderTraversal(TreeNode root, int k) {
        // base case: current node is null
        if (root == null) {
            return;
        }
        
        // visit left first
        inorderTraversal(root.left, k);
        // visit the current node
        count++;
        if (count == k) {
            result = root.val;
        }
        // visit the right side
        if (count < k) {
            inorderTraversal(root.right, k);
        }   
    }
}
