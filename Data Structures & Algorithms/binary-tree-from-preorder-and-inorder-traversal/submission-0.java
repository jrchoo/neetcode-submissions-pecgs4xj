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
    private HashMap<Integer, Integer> map = new HashMap<>();
    private int preorderIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // store the node and its index for fast lookup
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        int left = 0;
        int right = preorder.length - 1;
        return build(preorder, left, right);
    }

    public TreeNode build(int[] preorder, int left, int right) {
        if (left > right) {
            return null;
        }
        // grab the middle node
        int middle = preorder[preorderIndex++];
        TreeNode rootNode = new TreeNode(middle);
        //find its position in inorder array
        int mid = map.get(middle);
        
        rootNode.left = build(preorder, left, mid - 1);
        rootNode.right = build(preorder, mid + 1, right);

        return rootNode;
    }
}
