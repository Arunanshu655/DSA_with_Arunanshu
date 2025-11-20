// Topics: Dynamic Programming

import java.util.*;
public class Solution {
	static int[][] dp;
	public static int helper(int[] arr, int idx, int s, int sum){
		if(s * 2 > sum || idx == arr.length) return 0;
		if(2 * s == sum) return 1;
		if(dp[idx][s] != -1) return dp[idx][s];
		int take = helper(arr,idx+1,s+arr[idx],sum);
		int notTake = helper(arr,idx+1,s,sum);

		dp[idx][s] =  (take | notTake);
		return dp[idx][s];
	}
	public static boolean canPartition(int[] arr, int n) {
		// Write your code here.
		int sum = 0;
		for(int a : arr) sum += a;
		if(sum % 2 != 0) return false;
		boolean[] prev = new boolean[sum+1];
		boolean[] curr = new boolean[sum+1];
		prev[sum/2] = true; curr[sum/2] = true;
		for(int i = n - 2 ; i >= 0 ; i--){
			for(int s = 0 ; s <= sum/2 ; s++){
				boolean take = (s+ arr[i]<=sum) ? prev[s+ arr[i]] : false;
				boolean notTake = prev[s];
				curr[s] = (take | notTake);
			}
			prev = curr;
		}

		return curr[0];
	}
}


// Time Complexity: O(n * S)
// Auxiliary Space: O(S) => S is the sum of the elements
