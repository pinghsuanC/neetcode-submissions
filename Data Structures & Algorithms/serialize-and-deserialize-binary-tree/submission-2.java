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
        Queue<TreeNode> queue = new LinkedList<>();
        List<String> arr = new ArrayList<>();
        
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode ele = queue.poll();
            if(ele == null){
                arr.add("null");
                continue;
            } else {
                arr.add(ele.val+"");
            }

            queue.offer(ele.left);
            queue.offer(ele.right);
        }
        
        return String.join(",", arr);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        return helper(arr);
    }

    public TreeNode helper(String[] bfs){
        if(bfs.length == 0) return null;
        if("null".equals(bfs[0])) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        int i = 0;
        TreeNode root = new TreeNode(Integer.parseInt(bfs[0]));
        queue.offer(root);
        while(i < bfs.length && !queue.isEmpty()){
            TreeNode parent = queue.poll();

            if(i+1 < bfs.length && !"null".equals(bfs[i+1])){
                parent.left = new TreeNode(Integer.parseInt(bfs[i+1]));
                queue.offer(parent.left);
            }
            i++;

            if(i+1 < bfs.length && !"null".equals(bfs[i+1])){
                parent.right = new TreeNode(Integer.parseInt(bfs[i+1]));
                queue.offer(parent.right);
            }
            i++;
        }
        return root;
    }

}
