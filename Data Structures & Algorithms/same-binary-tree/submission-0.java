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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return helper(p, q);
    }

    public boolean helper(TreeNode node1, TreeNode node2){
        boolean equal = compVal(node1, node2);
        if(!equal) return false;
        if(node1 == null && node2 == null) return true;

        boolean left = helper(node1.left, node2.left);
        boolean right = helper(node1.right, node2.right);
        return left && right;
    }

    public boolean compVal(TreeNode node1, TreeNode node2){
        if(node1 == null && node2 == null){ return true; }
        if(node1 == null) return false; 
        if(node2 == null) return false;
        return node1.val == node2.val;
    }
}
