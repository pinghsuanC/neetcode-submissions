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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int high = Math.max(p.val, q.val);
        int low = Math.min(p.val, q.val);
        TreeNode pt = root;

        while(pt != null){
            if(high < pt.val){
                pt = pt.left;
            } else if (low > pt.val){
                pt = pt.right;
            } else {
                return pt;
            }
        }

        return pt;
    }
}
