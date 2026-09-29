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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        /*
        traverse until left < node < right
        let's say we want to insert node k
        omit the == case for now for simplicity, its guaranteed that node valud doesn't exist

        if we are at a node where
            node.left < node < node.right (BST property)
            and we have node.left < k < node.right, we reach the point of insertion
            
        if k.val < node.val, we need to make k the new left
            node.left < k, so node.left will be a new left branch for k
            k has no right branch
        
        if k.val > node.val, we need to make k the new right
            node.right > k, so node.right will be a new right branch for k
            k has no left branch
        
        insert and return the root in the helper function and return the root node int he main
        */
        if(root == null) return new TreeNode(val);


        helper(root, new TreeNode(val));

        return root;
    }

    boolean done = false;
    private void helper(TreeNode node, TreeNode newNode){
        if(node == null) return;
        System.out.println(node.val);

        if(node.val > newNode.val) helper(node.left, newNode);
        if(node.val < newNode.val) helper(node.right, newNode);

        boolean isNodeValid = (node.left == null || node.left.val < newNode.val) && (node.right == null || node.right.val > newNode.val);
        if(isNodeValid && !done){
            done = true;

            if(node.val > newNode.val){
                TreeNode tmp = node.left;
                node.left = newNode;
                if(tmp != null && tmp.val < newNode.val){
                    newNode.left = tmp;
                } else {
                    newNode.right = tmp;
                }
            } else {
                TreeNode tmp = node.right;
                node.right = newNode;
                if(tmp != null && tmp.val < newNode.val){
                    newNode.left = tmp;
                } else {
                    newNode.left = tmp;
                }
            }
            return;
        }
    }

}