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
    List<Integer> res;
    int maxRight;
    public List<Integer> rightSideView(TreeNode root) {
        res = new ArrayList<>();
        maxRight = Integer.MIN_VALUE;
        helper(root, 0);
        return res;
    }

    public void helper(TreeNode node, int depth){
        if(node == null) return;
        if(depth > maxRight){
            res.add(node.val);
            maxRight = Math.max(depth, maxRight);
        }
        helper(node.right, depth+1);
        helper(node.left, depth+1);
    }
}






