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
        if(root == null) return res;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        
        while(!queue.isEmpty()){
            int curSize = queue.size();
            List<Integer> tmp = new ArrayList<>();
            for(int i = 0; i < curSize; i++){
                TreeNode ele = queue.poll();
                tmp.add(ele.val);
                if(ele.left != null) queue.offer(ele.left);
                if(ele.right != null) queue.offer(ele.right);
            }
            res.add(tmp);
        }

        return res;
    }
}
