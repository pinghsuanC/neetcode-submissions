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
    public int goodNodes(TreeNode root) {
        return findGoodNode(root, Integer.MIN_VALUE);
    }

    public int findGoodNode(TreeNode node, int max){
        if(node == null){ return 0;}
        int localMax = Math.max(node.val, max);
        if(node.val >= max){
            return 1 + findGoodNode(node.right, localMax) + findGoodNode(node.left, localMax);
        }else {
            return findGoodNode(node.right, localMax) + findGoodNode(node.left, localMax);
        }
    }
}
