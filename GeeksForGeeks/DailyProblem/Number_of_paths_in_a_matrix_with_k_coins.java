// Topics: Dynamic Programming

class Solution {
    public int helper(int x, int y, int[][] mat, int k, int[][][] dp){
        if(x == mat.length-1 && y == mat[0].length-1 && k==mat[x][y]) return 1;
        if(x>=mat.length || y>=mat[0].length || k<0) return 0;
        
        
        if(dp[x][y][k] != -1) return dp[x][y][k];
        
        int right = helper(x+1,y,mat,k-mat[x][y],dp);
        int down = helper(x,y+1,mat,k-mat[x][y],dp);
        
        dp[x][y][k] = (right + down);
        return dp[x][y][k];
    }
    public int numberOfPath(int[][] mat, int k) {
        // code here
        int m = mat.length, n = mat[0].length;
        int[][][] dp = new int[m][n][k+1];
        
        for(int[][] d1: dp){
            for(int[] d2 : d1) Arrays.fill(d2,-1);
        }
        return helper(0,0,mat,k,dp);
    }
}

// Time Complexity: O(n * m * k)
// Auxiliary Space: O(n * m * k)
