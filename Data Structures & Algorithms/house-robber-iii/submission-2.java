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

 /*
 intuition:
 - bianry tree (left < node < right)
 - no two directly-linked houses allowed
 - need maximun money without alerting the police
 

 house robbers are known for their dynamic programming approach (recursive)
 tree is natually recursive, so will try this route
 */
class Solution {
    Map<TreeNode, int[]> dp;
    public int rob(TreeNode root) {
        dp = new HashMap<>();
        return helper(root, true);
    }

    private int helper(TreeNode node, boolean canTake){
        if(node == null) return 0;
        if(dp.containsKey(node) && dp.get(node)[canTake ? 1 : 0] >= 0) return dp.get(node)[canTake ? 1 : 0];

        // At the node position, either rob or not rob
        // don't rob this node, then possible to take both child nodes
        int res = helper(node.left, true) + helper(node.right, true);

        // if can rob this node, rob, then lost the ability to rob either child
        if(canTake){
            res = Math.max(res, node.val + helper(node.left, false) + helper(node.right, false));
        }


        dp.putIfAbsent(node, new int[]{-1, -1});
        dp.get(node)[canTake ? 1 : 0] = res;

    
        return res;
    }
    
}