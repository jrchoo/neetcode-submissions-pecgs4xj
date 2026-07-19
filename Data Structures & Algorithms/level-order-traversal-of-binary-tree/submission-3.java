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
        // brute force solution: manually iterate through every single node of the tree and add its
        // value to a list, after all node values in that level have been added, add the intermediate
        // list to a final list

        // optimised approach: level order traversal, BFS with a queue to process the nodes at every level
        // time complexity: O(n) to visit all nodes, space complexity: O(n), every node is added/popped from
        // the queue once

        // list to hold the final results
        List<List<Integer>> result = new ArrayList<>();
        // base case: 0 nodes or empty tree
        if (root == null) {
            return result;
        }

        // queue to store the nodes
        Queue<TreeNode> queue = new LinkedList<>();
        // put the root into the queue
        queue.offer(root);

        while (!queue.isEmpty()) {
            // only process as many nodes as there are in this level of the tree
            int level = queue.size();
            // intermediate list to hold the values at this level
            List<Integer> subList = new ArrayList<>();

            for (int i = 0; i < level; i++) {
                TreeNode curr = queue.poll();
                subList.add(curr.val);

                // add the children if there are any
                // always start with the left
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                // followed by the right
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            // all nodes at this level have been explored, add the intermediate list to the final list
            result.add(subList);
        }

        return result;
    }
}
