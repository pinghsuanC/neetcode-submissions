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
    List<List<Integer>> res;
    public List<List<Integer>> levelOrder(TreeNode root) {
        res = new ArrayList<>();
        helper(root, 0);
        return res;
    }

    public void helper(TreeNode node, int height){
        if(node == null) return;
        // add list for this level
        if(res.size() <= height){
            res.add(new ArrayList<>());
        }
        res.get(height).add(node.val);
        helper(node.left, height+1);
        helper(node.right, height+1);
    }
}
