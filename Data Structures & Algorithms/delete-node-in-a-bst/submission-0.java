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
    public TreeNode deleteNode(TreeNode root, int key) {
        // base case: empty tree/key not found
        if (root == null) {
            return null;
        }

        // traverse the BST to find the target node
        if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else { // target node has been found
            // case: target node has 0 or 1 children
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else { // third: target has 2 children
                // find the in-order successor to take its place
                // which is the smallest node in the right subtree
                TreeNode successor = findMin(root.right);
                root.val = successor.val;
                root.right = deleteNode(root.right, successor.val);
            }
        }
        
        return root;
    }

    public TreeNode findMin(TreeNode root) {
        // find the minimum node
        TreeNode curr = root;
        while (curr.left != null) {
            curr = curr.left;
        }

        return curr;
    }
}