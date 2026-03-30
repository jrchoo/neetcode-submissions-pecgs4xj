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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder finalString = new StringBuilder();
        buildString(root, finalString);
        return finalString.toString();
    }

    public void buildString(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("N");
            sb.append(",");
            return;
        }

        // append current node to string
        sb.append(root.val);
        sb.append(",");
        // traverse left
        buildString(root.left, sb);
        // traverse right
        buildString(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // create a queue with the characters of the string
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return buildTree(queue);
    }

    public TreeNode buildTree(Queue<String> queue) {
        String value = queue.poll();
        if (value.equals("N")) {
            return null;
        }

        TreeNode curr = new TreeNode(Integer.parseInt(value));
        curr.left = buildTree(queue);
        curr.right = buildTree(queue);

        return curr;
    }
}
