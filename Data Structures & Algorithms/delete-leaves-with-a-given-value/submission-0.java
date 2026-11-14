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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        return helper(root, target);
    }

    public TreeNode helper(TreeNode node, int target){
        if(node == null) return null;

        node.left = helper(node.left, target);
        node.right = helper(node.right, target);

        if(node.val == target && node.left == null && node.right == null){
            // parent needs to know if the the children is a leaf
            return null;
        }

        // parent safe so no need to remove
        return node;
    }
}