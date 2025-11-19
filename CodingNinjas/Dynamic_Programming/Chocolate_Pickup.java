// Topics: Dynamic Programming

import java.util.* ;
import java.io.*; 
public class Solution {
	public static int[][][] dp;
	public static int helper(int x, int y1, int y2, int[][] grid){
		if(x==grid.length-1){
			if(y1==y2) return grid[x][y1];
			else return grid[x][y1] + grid[x][y2]; 
		}
		
		if(dp[x][y1][y2] != -1) return dp[x][y1][y2];
        int max = 0;
		for(int i = y1-1 ; i<=y1+1 ; i++){
			for(int j = y2-1 ; j<=y2+1 ; j++){
				if(i>=0 && j>= 0 && i<grid[0].length && j < grid[0].length){
					int max1 = 0;
					if(y1==y2)  max1 = grid[x][y1] + helper(x+1,i,j,grid);
					else max1 =  grid[x][y1] + grid[x][y2] + helper(x+1,i,j,grid); 
					max = Math.max(max,max1);
				}
			}
		}

		dp[x][y1][y2] = max;
		return dp[x][y1][y2];
	}
	public static int maximumChocolates(int r, int c, int[][] grid) {
		// Write your code here.
		dp = new int[r][c][c];
		for(int[][] d1 : dp)
			for(int[] d2 : d1) Arrays.fill(d2,-1);
		return helper(0,0,c-1,grid);
	}
}

// Time Compleixty: O( r * c * c)
// Auxiliary Space: O( r * c * c)
