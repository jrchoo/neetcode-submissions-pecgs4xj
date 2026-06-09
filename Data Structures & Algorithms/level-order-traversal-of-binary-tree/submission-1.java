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
    public List<List<Integer>> levelOrder(TreeNode root) {
        // list to hold the final results
        List<List<Integer>> results = new ArrayList<>();
        if (root == null) {
            return results;
        }
        // queue to keep track of the nodes in each level
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int level = queue.size(); // process only the number of nodes at this level
            List<Integer> inter = new ArrayList<>(); // list to hold the intermediate results
            for (int i = 0; i < level; i++) {
                TreeNode curr = queue.poll();
                inter.add(curr.val);

                if (curr.left != null) {
                    queue.offer(curr.left);
                }

                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            results.add(new ArrayList<>(inter));
        }

        return results;
    }
}
