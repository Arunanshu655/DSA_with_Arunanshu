// Topics: Dynamic Programming

import java.util.* ;
import java.io.*; 
public class Solution {
    public static int minSumPath(int[][] grid) {
    	// Write your code here.
        int m = grid.length, n = grid[0].length;

        for(int i = m - 1; i>= 0 ; i--){
            for(int j = n - 1; j>= 0; j--){
                int route = Integer.MAX_VALUE;
                if(i<m-1) route = Math.min(route,grid[i+1][j]);
                if(j<n-1) route = Math.min(route,grid[i][j+1]);
                grid[i][j] += (route != Integer.MAX_VALUE) ? route : 0;
            }
        }
        // for(int[] g : grid)
        //     for(int g1 : g) System.out.print(g1 + " ");
        return grid[0][0];
    }
}

// Time Complexity: O(m * n)
// Auxiliary Space; O(1) 
