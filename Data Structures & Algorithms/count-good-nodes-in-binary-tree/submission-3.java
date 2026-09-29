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
        return findGoodNode(root, root.val);
    }

    public int findGoodNode(TreeNode node, int max){
        if(node == null){ return 0; }
        if(node.val < max){ 
            return findGoodNode(node.right, max) + findGoodNode(node.left, max);
        }
        return 1 + findGoodNode(node.right, node.val) + findGoodNode(node.left, node.val);
    }
}
