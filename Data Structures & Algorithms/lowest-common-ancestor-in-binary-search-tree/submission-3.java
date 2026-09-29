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

    public TreeNode helper(TreeNode node, int p, int q){
        if(node == null) return node;
        int v = node.val;
        if(v < p && v < q){
            return helper(node.right, p, q);
        }else if(v > p && v > q){
            return helper(node.left, p, q);
        }else{
            return node;
        }
    }
}
