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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
       return checkTree(root, subRoot) 
            || (root != null && isSubtree(root.left, subRoot)) 
            || (root != null && isSubtree(root.right, subRoot));
    }

    public boolean checkTree(TreeNode root, TreeNode subRoot){
        if(root == null && subRoot != null || root != null && subRoot == null) return false;
        if(root == null && subRoot == null) return true;
        if(root.val != subRoot.val) return false;

        return checkTree(root.left, subRoot.left) && checkTree(root.right, subRoot.right); 
    }

}
