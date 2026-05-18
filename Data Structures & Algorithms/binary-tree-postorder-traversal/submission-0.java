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
    public List<Integer> postorderTraversal(TreeNode root) {
        // postorder traversal (left -> right -> root)
        List<Integer> postOrder = new ArrayList<>();

        dfs(root, postOrder);

        return postOrder;
    }

    public void dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        // go left
        dfs(root.left, list);
        // go right
        dfs(root.right, list);
        // add node value
        list.add(root.val);
    }
}