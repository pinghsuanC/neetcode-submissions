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

    public void helper(TreeNode node, int acc){
        if(node == null) return;

        if(res.size() <= acc){
            res.add(new ArrayList<>());
        }

        res.get(acc).add(node.val);
        helper(node.left, acc+1);
        helper(node.right, acc+1);
    }
}
