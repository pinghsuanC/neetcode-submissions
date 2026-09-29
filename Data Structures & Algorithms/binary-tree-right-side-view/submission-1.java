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
    int max = Integer.MIN_VALUE;
    List<Integer> res;
    public List<Integer> rightSideView(TreeNode root) {
        res = new ArrayList<Integer>();
        dfs(root, 0);
        return res;
    }

    public int dfs(TreeNode node, int acc){
        if(node == null) return acc;
        if(acc >= max){
            res.add(node.val);
        }
        int right = dfs(node.right, acc+1);
        max = Math.max(right, max);
        int left = dfs(node.left, acc+1);
        return max;
    }
}
