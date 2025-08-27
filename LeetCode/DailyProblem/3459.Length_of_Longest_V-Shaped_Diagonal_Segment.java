// Topics: Dynamic Programming

class Solution {
    private int[][] dirs = {{-1,-1},{-1,1},{1,1},{1,-1}};
    public boolean is9T(int from, int to){
    return (from+1)%4 == to;
    }
    public boolean isPos(int n , int m, int i, int j){
        return (i<n && j<m && i>=0 && j>=0);
    }
    public boolean isComp(int[][] grid,int i, int j, int x, int y){
        if(grid[i][j] == 1 && grid[x][y] == 2) return true;
        return ((grid[i][j]==2 && grid[x][y]==0) || (grid[i][j]==0 && grid[x][y]==2));
    }
    public int solve(int[][] grid, int i, int j, int dir, int changed, int[][][][] dp){
        if(dp[i][j][dir+1][changed] != -1) return dp[i][j][dir+1][changed];
        int ans = 0;
        for(int k = 0 ; k < 4 ; k++){
            int x = i + dirs[k][0];
            int y = j + dirs[k][1];
            if(isPos(grid.length,grid[0].length,x,y)&& isComp(grid,i,j,x,y)){
                if(dir == -1 || k == dir) ans = Math.max(ans,1+solve(grid,x,y,k,changed,dp));
                else if(changed == 0 && is9T(dir,k)) ans = Math.max(ans,1+solve(grid,x,y,k,1,dp));
            }
        }
        dp[i][j][dir+1][changed] = ans;
        return dp[i][j][dir+1][changed];
    }
    public int lenOfVDiagonal(int[][] grid) {
        int n = grid.length, m = grid[0].length, ans = 0;
        int[][][][] dp = new int[n][m][5][2];
        for(int[][][] d : dp){
            for(int[][] d1 : d){
                for(int[] d2: d1) Arrays.fill(d2,-1);
            }
        }
        for(int i = 0 ; i < n  ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j]==1) ans = Math.max(ans,1+solve(grid,i,j,-1,0,dp));
            }
        }
        return ans;
    }
}


// Time Complexity: O(n*m);
// Auxiliary Space: O(n*m);
