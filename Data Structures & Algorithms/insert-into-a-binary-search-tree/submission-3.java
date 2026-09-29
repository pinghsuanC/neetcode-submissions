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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        
        if(root == null) return new TreeNode(val);
        helper(root, new TreeNode(val));

        return root;
    }

    private void helper(TreeNode node, TreeNode newNode){
        if(node == null) return;

        if(newNode.val < node.val){
            if(node.left == null){
                node.left = newNode;
                return;
            }
            helper(node.left, newNode);
        } else {
            if(node.right == null){
                node.right = newNode;
                return;
            }
            helper(node.right, newNode);
        }

    }
}