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
    public List<Integer> inorderTraversal(TreeNode root) {
        // inorder traversal (left -> root -> right)
        List<Integer> inOrder = new ArrayList<>();

        dfs(root, inOrder);

        return inOrder;
    }

    public void dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        // always go left first
        dfs(root.left, list);
        // node itself
        list.add(root.val);
        // go right
        dfs(root.right, list);
        
    }
}