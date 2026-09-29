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
    boolean res;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        res = false;
        helper(root, targetSum);
        return res;
    }

    public void helper(TreeNode node, int target){
        if(node == null) return;
        if(target == node.val && node.left == null && node.right == null) {
            res = true;
            return;
        }

        helper(node.left, target - node.val);
        helper(node.right, target - node.val);
    }
}