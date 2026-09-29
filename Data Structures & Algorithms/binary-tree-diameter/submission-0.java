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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] res = new int[1];
        helper(root, res);
        return res[0];
    }

    public int helper(TreeNode node, int[] res){
        if(node == null) return 0;
        int left = helper(node.left, res);
        int right = helper(node.right, res);
        res[0] = Math.max(res[0], left+right);

        return 1 + Math.max(left, right);
    }
}
