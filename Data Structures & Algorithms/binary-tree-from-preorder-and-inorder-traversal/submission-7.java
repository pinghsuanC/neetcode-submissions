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
    Map<Integer, Integer> indices = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++){
            indices.put(inorder[i], i);
        }
        return helper(preorder, inorder, 0, 0, inorder.length - 1);
    }

    public TreeNode helper(int[] preorder, int[] inorder, int i, int l, int r){
        if(i >= preorder.length || l > r){
            return null;
        }

        int mid = indices.get(preorder[i]);
        TreeNode root = new TreeNode(preorder[i]);
        root.left = helper(preorder, inorder, i+1, l, mid-1);
        root.right = helper(preorder, inorder, i + (mid - l) + 1, mid+1, r);

        return root;
    }
}
