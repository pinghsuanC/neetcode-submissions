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
    /*
    intuition:
    finding is easy by dfs and recursion
    but after removing, need to keep the bst structure

    at each, we have right > node > left

    if node == target
    -> if node.left = null, node.right is the answer
    -> if node.right = null, node.left is the answer
    -> if both not null, then
        -> promote right node
        -> find left leaf node of the right tree (right must be > than left, so it will be valid at leaf)
        -> attach node.left to leaf.left

  */
    public TreeNode deleteNode(TreeNode root, int key) {
        
        return helper(root, key);
    }

    public TreeNode helper(TreeNode node, int key){
        if(node == null) return node;

        if(node.val < key){
            node.right = helper(node.right, key);
        } else if(node.val > key) {
            node.left = helper(node.left, key);
        } else {
            if(node.left == null) return node.right;
            if(node.right == null) return node.left;

            // both of them are not empty, promote right node and move left node to right leaf
            TreeNode res = node.right, leaf = node.right;

            while(leaf.left != null) leaf = leaf.left;
            leaf.left = node.left;

            node = null;
            return res;
        }

        return node;
    }

}