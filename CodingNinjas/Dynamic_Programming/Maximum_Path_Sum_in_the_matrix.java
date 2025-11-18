// Topics: Dynamic Programming

import java.util.* ;
import java.io.*; 

public class Solution {
	public static int getMaxPathSum(int[][] matrix) {
		// Write your code here
		int n = matrix.length, m = matrix[0].length;
		for(int i = n - 2; i>= 0; i--){
			for(int j = 0 ; j < m ; j++){
				int val = matrix[i+1][j];
				if(j>0) val = Math.max(val,matrix[i+1][j-1]);
				if(j<m-1) val = Math.max(val,matrix[i+1][j+1]);
				matrix[i][j] += val;				
			}
		}
		// for(int i = 0 ; i < n ; i++, System.out.println())
		// 	for(int j = 0 ; j < m ; j++) System.out.print(matrix[i][j] + " ");
		int max = Integer.MIN_VALUE;
		for(int i = 0 ; i < m ; i++) max = Math.max(max,matrix[0][i]);
		return max;
	}
}


// Timce Compleixty: O( n * m )
// Auxiliary Space: O(1)
