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
    int res;
    public int kthSmallest(TreeNode root, int k) {
        // intuition: since it's a BST, left < node < right
        // to find the kth smallest, it's to find the node where #left = k from the bottom left
        // so traverse to the bottom of left
        // then parent, then right
        // count to k+1 after hitting the base case
        res = -1;
        helper(root, new int[1], k);
        return res;
    }
    
    public void helper(TreeNode node, int[] count, int k){
        if(node == null) return;
        helper(node.left, count, k);
        count[0]++;
        if(count[0] == k) res = node.val;
        helper(node.right, count, k);
    }
}




