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
    int resH;
    TreeNode res;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        res = root;
        resH = 0;
        int high = Math.max(p.val, q.val);
        int low = Math.min(p.val, q.val);
        helper(root, low, high, 0);
        return res;
    }

    public void helper(TreeNode node, int p, int q, int height){
        if(node == null) return;
        int v = node.val;
        if(isValidParent(node, p, q)){
            if(height > resH){
                resH = height;
                res = node;
            }
        }
        if(q < v){
            // go to the left tree
            helper(node.left, p, q, height+1);
        } 
        if (p > v) {
            helper(node.right, p, q, height+1);
        }
    }

    public boolean isValidParent(TreeNode node, int p, int q){
        int v = node.val;
        if(node == null) return false;
        if(node.left == null && node.right == null) return false;
        return v >= p && v <= q;
    }
}
