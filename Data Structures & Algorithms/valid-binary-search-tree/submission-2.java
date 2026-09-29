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
    static boolean check_right(int val, int limit){
        return val > limit;
    }
    static boolean check_left(int val, int limit){
        return val < limit;
    }

    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        if(!isValidValue(root.left, root.val, Solution::check_left)
        || !isValidValue(root.right, root.val, Solution::check_right)){
            return false;
        }
        return isValidBST(root.left) && isValidBST(root.right);
    }

    public boolean isValidValue(TreeNode root, int limit, CheckFunction check){
        if(root == null){
            return true;
        }
        if(!check.apply(root.val, limit)){
            return false;
        }
        return isValidValue(root.left, limit, check) && isValidValue(root.right, limit, check);
    }


    interface CheckFunction{
        boolean apply(int val, int limit);
    }
}
