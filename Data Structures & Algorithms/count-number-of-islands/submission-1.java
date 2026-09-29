class Solution {
    List<Integer> visited;
    public int numIslands(char[][] grid) {
        visited = new ArrayList<>();
        int count = 0;
        // traverse and find the first 1
        // count of land ++
        // for that coordinate, enter the findIsland helper inorder to mark the connected coordinates
        // return count 
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(visited.contains(i*grid.length+j)) continue;
                if(grid[i][j] == '1'){
                    //System.out.println("caught at " + i + " " + j);
                    count++;
                    markLandsByCoordinate(grid, i, j);
                }
            }
        }
        //for(char[] g : grid){
            //System.out.println(Arrays.toString(g));
        //}
        return count;
    }

    public void markLandsByCoordinate(char[][] grid, int i, int j){
        int m = grid.length,
            n = grid[0].length;
        if(visited.contains(i*m+j)) return;
        if(i < 0 || i >= m || j < 0 || j >=n) return;
        if(grid[i][j] == '0') return;
        if(grid[i][j] == '1'){
            //visited.add(i*m+j);
            // sink the island instead of marking it?
            grid[i][j] = '0';
            //System.out.println(i + " " + j + " marked.");
            markLandsByCoordinate(grid, i+1, j);
            markLandsByCoordinate(grid, i-1, j);
            markLandsByCoordinate(grid, i, j-1);
            markLandsByCoordinate(grid, i, j+1);
            visited.add(i*m+j);
        }
    }
}
