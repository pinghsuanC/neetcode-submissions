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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    public int getMax(TreeNode node){
        if(node==null) return 0;
        int left = getMax(node.left);
        int right = getMax(node.right);
        int path = node.val + Math.max(left, right);
        return Math.max(0, path);
    }

    private void dfs(TreeNode node){
        if(node == null) return;
        int left = getMax(node.left);
        int right = getMax(node.right);
        max = Math.max(max, node.val+left+right);
        dfs(node.left);
        dfs(node.right);
    }
}
