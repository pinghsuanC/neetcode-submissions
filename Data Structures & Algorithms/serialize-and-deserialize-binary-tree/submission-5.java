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

public class Codec {

    int i;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> arr = new ArrayList<>();
        helper(root, arr);
        return String.join(",", arr);
    }

    private void helper(TreeNode node, List<String> arr){
        if(node == null){
            arr.add("null");
            return;
        }

        arr.add(node.val+"");
        helper(node.left, arr);
        helper(node.right, arr);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        i = 0;
        String[] arr = data.split(",");

        return helper(arr);
    }

    private TreeNode helper(String[] data){
        if("null".equals(data[i])) {
            i++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(data[i]));
        
        i++;
        root.left = helper(data); 
        root.right = helper(data);
        
        
        return root;
    }
}
