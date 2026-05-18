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
    public List<Integer> preorderTraversal(TreeNode root) {
        // preorder traversal (root -> left -> right)
        List<Integer> preOrder = new ArrayList<>();

        dfs(root, preOrder);

        return preOrder;
    }

    public void dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        // add node itself
        list.add(root.val);
        // go left
        dfs(root.left, list);
        // go right
        dfs(root.right, list);
    }
}