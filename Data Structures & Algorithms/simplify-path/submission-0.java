class Solution {
    public String simplifyPath(String path) {
        /*
        intuition: use stack to track
        - maybe split by '/' 
            -> 1 /, it gives the folder names
            -> 2 //, it becomes empty String
            -> 3+ ///, it all becomes empty strings
            so i think split by '/' works well
        - now have a list of tokens, just need to handle the dots
            -> length > 2, then it's a valid directory, push to stack
            -> length < 2, then it's '.' current directory, just ignore
            -> length == 2, then pop the previous directory
        */
        Stack<String> stack = new Stack<>();

        String[] tokens = path.split("/");

        for(String t : tokens){
            if("".equals(t)) continue;
            if(".".equals(t)) continue;
            
            if("..".equals(t)){
                if(!stack.isEmpty()) stack.pop();
            } else {
                stack.push(t);
            }
        }

        List<String> arr = new ArrayList<>();
        while(!stack.isEmpty()){
            String t = stack.pop();
            arr.add(t);
        }

        return "/"+String.join("/", arr.reversed());
    }
}