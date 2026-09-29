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
    int right;
    public List<Integer> rightSideView(TreeNode root) {
        // intuition of dfs:
        // track how deep is the right tree first, 
        // and then when checking the eft tree, 
            // only anything deeper than the height of the right tree should be counted
        res = new ArrayList<>();
        right = Integer.MIN_VALUE;
        helper(root, 0);
        return res;
    }

    private void helper(TreeNode root, int dep){
        if(root == null) return;
        if(dep > right){
            res.add(root.val);
            right = Math.max(right, dep);
        }
        helper(root.right, dep+1);
        helper(root.left, dep+1);
        
    }
}






