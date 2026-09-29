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
    public int goodNodes(TreeNode root) {
        // intuition: DFS, need to trak the maximun of the path
        // if current node is < maximun, it's not a good node
        // if current node is > maximun, we need to update the maximun. it is a good node
        
        return helper(root, root.val);
    }

    private int helper(TreeNode node, int max){
        if(node == null) return 0;
        if(node.val >= max){
            return 1 + helper(node.left, node.val) + helper(node.right, node.val);
        } else {
            return helper(node.left, max) + helper(node.right, max);
        }
    }




}





