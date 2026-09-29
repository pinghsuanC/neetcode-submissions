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
        int[] bfs = new int[arr.length];
        System.out.println(data);
        for(int i = 0; i < arr.length; i++){
            if("null".equals(arr[i])){
                bfs[i] = -1001;
            } else{
                bfs[i] = Integer.parseInt(arr[i]);
            }
        }

        return helper(bfs);
    }

    public TreeNode helper(int[] bfs){
        if(bfs.length == 0) return null;
        if(bfs[0] == -1001) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        int i = 0;
        TreeNode root = new TreeNode(bfs[0]);
        queue.offer(root);
        while(i < bfs.length && !queue.isEmpty()){
            TreeNode parent = queue.poll();
            if(parent.val == -1001){
                // null
                continue;
            }
            System.out.println(bfs[i+1]);
            if(i+1 < bfs.length && bfs[i+1] != -1001){
                parent.left = new TreeNode(bfs[i+1]);
                queue.offer(parent.left);
            }
            i++;

            if(i+1 < bfs.length && bfs[i+1] != -1001){
                parent.right = new TreeNode(bfs[i+1]);
                queue.offer(parent.right);
            }
            i++;
        }
        return root;
    }

}
