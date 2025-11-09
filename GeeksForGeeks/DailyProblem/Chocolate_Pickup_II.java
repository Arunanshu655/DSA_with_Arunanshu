// Topics: Dynamic Programming

class Solution {
    int[][][] dp;
    public int helper(int[][] mat,int r1, int c1, int r2){
       int c2 = r1 + c1 - r2;
       int n = mat.length;
       if(r1>=n || r2>=n|| c1>=n || c2>=n) return Integer.MIN_VALUE;
       
       if(mat[r1][c1] == -1 || mat[r2][c2] == -1) return Integer.MIN_VALUE;
        
        if (r1 == n-1 && c1 == n-1) return mat[r1][c1];

        
        if(dp[r1][c1][r2] != -2) return dp[r1][c1][r2];
        int val = mat[r1][c1];
        if(r2 != r1 || c1 != c2) val += mat[r2][c2];
        
        int max = Integer.MIN_VALUE;
        
        max = Math.max(max, helper(mat, r1+1, c1, r2+1)); //dd
        max = Math.max(max, helper(mat, r1+1, c1, r2));//dr
        max = Math.max(max, helper(mat, r1, c1+1, r2+1));//rd
        max = Math.max(max, helper(mat, r1, c1+1, r2));//rr
        
        if(max == Integer.MIN_VALUE) dp[r1][c1][r2] = Integer.MIN_VALUE;
        
        return dp[r1][c1][r2] = val + max;
        
    }
    public int chocolatePickup(int[][] mat) {
        // code here
        int n = mat.length;
        dp = new int[n][n][n];
        
        for(int[][] d1 : dp){
            for(int[] d2 : d1) Arrays.fill(d2, -2);
        }
        
        int res = helper(mat, 0, 0, 0);
        
        return Math.max(res,0);
    }
}


// Time Complexity: O(n^3)
// Auxiliary Space: O(n^3)
