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
        return goodNode(root, root.val);
    }

    public int goodNode(TreeNode node, int max){
        if(node == null) return 0;
        if(node.val >= max){
            return 1 + goodNode(node.left, node.val) + goodNode(node.right, node.val);
        }
        return goodNode(node.left, max) + goodNode(node.right, max);
    }
}
