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
    int max;
    public int maxDepth(TreeNode root) {
        max = 0;
        helper(root, 0);
        return max;
    }

    public void helper(TreeNode node, int rec){
        if(node == null) {
            max = Math.max(max, rec);
            return;
        }
        helper(node.left, 1+rec);
        helper(node.right, 1+rec);
    }
}
