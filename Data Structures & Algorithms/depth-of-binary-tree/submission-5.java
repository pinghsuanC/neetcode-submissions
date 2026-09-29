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
    public int maxDepth(TreeNode root) {
        return findMax(root, 0);
    }

    public int findMax(TreeNode node, int acc){
        if(node == null) return acc;

        int total = Math.max(findMax(node.left, 1+acc), findMax(node.right, 1+acc));
        return total;
    }
}
