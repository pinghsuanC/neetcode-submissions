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

    public int findMaxPath(TreeNode node){
        if(node == null) return 0;

        int left = Math.max(0, findMaxPath(node.left));
        int right = Math.max(0, findMaxPath(node.right));
        int path = node.val + Math.max(left, right);

        return Math.max(0, path);
    }

    public void dfs(TreeNode node){
        if(node == null) return;
        int leftMax = findMaxPath(node.left);
        int rightMax = findMaxPath(node.right);
        System.out.println(leftMax + " " + rightMax);
        max = Math.max(max, rightMax + leftMax + node.val);
        dfs(node.left);
        dfs(node.right);
    }
}








