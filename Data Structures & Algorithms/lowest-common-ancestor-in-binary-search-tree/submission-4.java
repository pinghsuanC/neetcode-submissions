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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root, Math.min(p.val, q.val), Math.max(p.val, q.val));
    }

    public TreeNode helper(TreeNode node, int min, int max){
        if(node == null) return null;
        if(node.val >= min && node.val <= max) return node;
        if(node.val > max) return helper(node.left, min, max);
        else {
            return helper(node.right, min, max);
        }
    }
}
