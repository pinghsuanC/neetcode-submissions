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
    int preInd = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++){
            indices.put(inorder[i], i);
        }
        preInd = 0;
        return helper(preorder, 0, inorder.length - 1);
    }

    public TreeNode helper(int[] preorder, int l, int r){
        if(l > r){
            return null;
        }

        int mid = indices.get(preorder[preInd]);
        TreeNode root = new TreeNode(preorder[preInd]);
        preInd++;
        root.left = helper(preorder, l, mid-1);
        root.right = helper(preorder, mid+1, r);

        return root;
    }
}
