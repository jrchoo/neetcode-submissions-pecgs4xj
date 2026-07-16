/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node construct(int[][] grid) {
        // run the build function starting from the top left (0, 0)
        return build(grid, 0, 0, grid.length);
    }

    private Node build(int[][] grid, int row, int col, int length) {
        // base case: a single cell
        if (length == 1) {
            boolean val = grid[row][col] == 1;
            return new Node(val, true);
        }

        // recurse into 4 smaller quadrants
        int half = length / 2; // m == n and n is a power of 2
        Node topLeft = build(grid, row, col, half);
        Node topRight = build(grid, row, col + half, half);
        Node bottomLeft = build(grid, row + half, col, half);
        Node bottomRight = build(grid, row + half, col + half, half);

        // if all 4 children have the same value and are leafs, able to merge
        if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf
            && topLeft.val == topRight.val
            && topRight.val == bottomLeft.val
            && bottomLeft.val == bottomRight.val) { // transitive property

            return new Node(topLeft.val, true); // all 4 leaves are identical
        }

        // otherwise, create a node but leave the children separated
        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }
}