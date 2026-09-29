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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, 0, inorder.length - 1);
    }

    public TreeNode helper(int[] preorder, int[] inorder, int i, int l, int r){
        if(i >= preorder.length || l > r){
            return null;
        }

        int mid = -1;
        for(int j = l; j <= r; j++){
            if(inorder[j] == preorder[i]){
                mid = j;
                break;
            }
        }

        TreeNode root = new TreeNode(preorder[i]);
        root.left = helper(preorder, inorder, i+1, l, mid-1);
        root.right = helper(preorder, inorder, i + (mid - l) + 1, mid+1, r);

        return root;
    }
}
