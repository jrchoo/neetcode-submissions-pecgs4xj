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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // check current node
        if (root == null) {
            return false;
        }
        // rigid inspector
        if (isSameTree(root, subRoot)) {
            return true;
        };
        // relentless searcher
        boolean searchLeft = isSubtree(root.left, subRoot);
        boolean searchRight = isSubtree(root.right, subRoot);
        

        return searchLeft || searchRight;
    }

    public boolean isSameTree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null) {
            return false;
        }
        if (root.val != subRoot.val) {
            return false;
        }

        boolean searchLeft = isSameTree(root.left, subRoot.left);
        boolean searchRight = isSameTree(root.right, subRoot.right);

        return searchLeft && searchRight;
    }
}
