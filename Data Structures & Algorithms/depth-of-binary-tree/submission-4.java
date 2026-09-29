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

    public int findMax(TreeNode root, int max){
        if(root == null){ return max; }
        int r = findMax(root.right, max + 1);
        int l = findMax(root.left, max + 1);
        return Math.max(r, l);
    }
}
