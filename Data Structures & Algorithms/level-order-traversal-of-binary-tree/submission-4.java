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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> q = new ArrayDeque<>();

        q.offer(root);
        while(!q.isEmpty()){
            List<Integer> tmp = new ArrayList<>();
            List<TreeNode> nodes = new ArrayList<>();
            while(!q.isEmpty()){
                nodes.add(q.poll());
            }
            for(TreeNode t : nodes){
                tmp.add(t.val);
                if(t.left != null) q.offer(t.left);
                if(t.right != null) q.offer(t.right);
            }
            res.add(tmp);
        }

        return res;
    }
}
