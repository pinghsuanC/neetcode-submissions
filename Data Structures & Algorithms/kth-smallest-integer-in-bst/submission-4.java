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
    public int kthSmallest(TreeNode root, int k) {
        int[] acc = new int[2];
        helper(root, k, acc);
        return acc[1];
    }

    public void helper(TreeNode node, int k, int[] acc){
        if(node == null) return;
        if(acc[0] >= k) return;
        helper(node.left, k, acc);
        if(acc[0] >= k) return;
        acc[0]++;
        if(acc[0] == k){
            acc[1] = node.val;
        }
        helper(node.right, k, acc);
        
    }
}
