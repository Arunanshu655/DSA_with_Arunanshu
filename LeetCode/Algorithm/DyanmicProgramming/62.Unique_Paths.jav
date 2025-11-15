// Topics: Dynamic Programming

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        grid[m-1][n-1] = 1;
        for(int i = m-1 ; i >= 0 ; i--){
            for(int j = n-1 ; j >= 0 ; j--){
                if(i>0) grid[i-1][j] += grid[i][j];
                if(j>0) grid[i][j-1] += grid[i][j];
            }
        }

        return grid[0][0];
    }
}

// Time Complexity: O(m*n)
// Auxiliary Space: O(m*n)
