/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     constructor(val = 0, left = null, right = null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    /**
     * @param {TreeNode} root
     * @return {number}
     */
    maxDepth(root) {
        if(!root) return 0;
        if(root.left == null && root.right == null){return 1;}
        let l = 0,
            r = 0;
        if(root.left){
            l = this.maxDepth(root.left);
        }
        if(root.right){
            r = this.maxDepth(root.right);
        }
        return Math.max(l,r) + 1;
    }
}
