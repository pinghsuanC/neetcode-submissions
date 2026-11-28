class Solution {
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        /*
        top-left -> bottom-right
        1 = obstacle
        0 = space
        path stops @ 1s

        need: total # of viable paths
        
        */

        if(obstacleGrid.length == 0) return 0;
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] tab = new int[m+1][n+1];
        tab[m-1][n-1] = 1;

        for(int i = m-1; i >= 0; i--){
            for(int j = n-1; j>=0; j--){
                if(obstacleGrid[i][j] == 1) {
                    tab[i][j] = 0;
                    continue;
                }
                tab[i][j] += tab[i+1][j] + tab[i][j+1];
            }
        }

        return tab[0][0];
    }

}