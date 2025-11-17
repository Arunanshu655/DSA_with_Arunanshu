// Topics: Dynamic Programming

import java.util.* ;
import java.io.*; 
public class Solution {
    public static int minimumPathSum(int[][] triangle, int n) {
        // Write your code here.
        for(int i = n-2 ; i >= 0 ; i--){
            for(int j = 0 ; j <= i ; j++)
                triangle[i][j] += Math.min(triangle[i+1][j],triangle[i+1][j+1]);
        }
        return triangle[0][0];
    }
}

// Time Complexity: O(n^2)
// Auxiliary Space: O(1)
