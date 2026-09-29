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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // Intuition: use BFS to contruct an array list of node values
        // And then use BFS to rebuild it
        // make use of the condition where node.val <= 1000 for convenience, but it can be N or other letters


        if(root == null) return "N";
        Queue<TreeNode> q = new LinkedList<>();
        List<String> arr = new ArrayList<>();

        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node == null) {
                arr.add("N");
            } else {
                arr.add(node.val+"");
                q.offer(node.left);
                q.offer(node.right);
            }
        }

        return String.join(";", arr);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if("N".equals(data)) return null;

        String[] strs = data.split(";");
        int[] vals = new int[strs.length];
        Queue<TreeNode> q = new LinkedList<>();
        
        // convert everything form string to integer, easier to work with 
        for(int i = 0; i < strs.length; i++){
            String s = strs[i];
            if("N".equals(s)){
                vals[i] = -1001;
            } else {
                vals[i] = Integer.parseInt(s);
            }
        }

        // Construct the root
        TreeNode root = new TreeNode(vals[0]);
        q.offer(root);
        int i = 0;
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            // get left child
            i++;
            if(vals[i] != -1001){
                node.left = new TreeNode(vals[i]);
                q.offer(node.left);
            }

            // get right child
            i++;
            if(vals[i] != -1001){
                node.right = new TreeNode(vals[i]);
                q.offer(node.right);
            }
        }


        return root;        
    }
}
