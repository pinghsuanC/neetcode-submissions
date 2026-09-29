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
    public boolean isValidBST(TreeNode root) {
        return isValidSub(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidSub(TreeNode node, long min, long max){
        if(node == null){ return true;}
        if(node.val <= min || node.val >= max){
            return false;
        }
        return (isValidSub(node.right, node.val, max) && isValidSub(node.left, min, node.val));
    }
}
