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
        /*
        intuition: the most important part is this:
            We can construct a Quad-Tree from a two-dimensional area using the following steps:
                1. isLeaf = true if
                        the current grid has the same value (i.e all 1's or all 0's) 
                        set isLeaf True,
                        set val to the value of the grid,
                        set the four children to Null and stop
                2. set isLeaf to False if
                        the current grid has different values, 
                        set val to any value,
                        divide the current grid into four sub-grids as shown in the photo.
                3. Recurse for each of the children with the proper sub-grid.

        - how to find a "grid"? What to recurse?
            given n == 2ˣ where 0 <= x <= 6, start with N
            for each grid (row size = n/2, col size = n/2), decide if the grid is a leaf
                If it's a leaf, stop recurse
                If it's not a leaf, enter (grid size) / 2
        
        */

        Node res = helper(grid, 0, 0, grid.length);

        return res;
    }

    private Node helper(int[][] grid, int i, int j, int size){

        // check if the grid is leaf
        if(isLeaf(grid, i, j, size)){
            // if it's leaf, can stop the recursion here, return the leaf node
            return new Node(grid[i][j]==1, true);
        }

        // not a leaf, need to create a non-leaf node and recurse
        // need to get the subdivision answers first
        int half = size/2;
        Node topLeft = helper(grid, i, j, half);
        Node topRight = helper(grid, i, j+half, half);
        Node bottomLeft = helper(grid, i+half, j, half);
        Node bottomRight = helper(grid, i+half, j+half, half);

        // here val = any value
        Node cur = new Node(grid[i][j]==1, false, topLeft, topRight, bottomLeft, bottomRight);

        return cur;
    }


    // i, j is the starting point at top left corner
    // optimize later, probably have some way to do it
    private boolean isLeaf(int[][] grid, int i, int j, int size){
        if(size == 1) return true; // size 1 has to be a leaf
        int k = grid[i][j];
        for(int r = 0; r < size; r++){
            for(int c = 0; c < size; c++){
                if(k != grid[r+i][c+j]) return false;
            }
        }
        return true;
    }


}