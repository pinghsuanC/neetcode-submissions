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
                if(visited.contains(i*grid[0].length+j)) continue;
                if(grid[i][j] == '1'){
                    count++;
                    markLandsByCoordinate(grid, i, j);
                }
            }
        }
        
        return count;
    }

    public void markLandsByCoordinate(char[][] grid, int i, int j){
        int m = grid.length,
            n = grid[0].length;
        if(i < 0 || i >= m || j < 0 || j >=n) return;
        if(grid[i][j] == '0' || visited.contains(i*n+j)) return;
        if(grid[i][j] == '1'){
            visited.add(i*n+j);
            // sink the island instead of marking it?
            //grid[i][j] = '0';
            markLandsByCoordinate(grid, i+1, j);
            markLandsByCoordinate(grid, i-1, j);
            markLandsByCoordinate(grid, i, j-1);
            markLandsByCoordinate(grid, i, j+1);
            //visited.add(i*m+j);
        }
    }
}
