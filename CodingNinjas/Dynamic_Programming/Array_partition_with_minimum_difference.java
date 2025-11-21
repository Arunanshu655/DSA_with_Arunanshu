// Topics: Dynamic Programming

public class Solution {
    static int[][] dp;
    public static int helper(int []arr, int n, int idx, int sum, int totSum){
        if(idx == n-1) return Math.min(Math.abs(2 * (sum + arr[idx])-totSum),Math.abs(2 * (sum)-totSum));
        
        if(dp[idx][sum] != -1) return dp[idx][sum];
        int incl = helper(arr,n,idx+1,sum+arr[idx],totSum);
        int excl = helper(arr,n,idx+1,sum,totSum);

        dp[idx][sum] = Math.min(incl, excl);

        return dp[idx][sum];
    }
    public static int minSubsetSumDifference(int []arr, int n) {
        // Write your code here.
        int sum = 0, diff = Integer.MAX_VALUE, currSum = arr[0];
        for(int a : arr) sum += a;
        
        dp = new int[n+1][sum+1];
        for(int i = 0 ; i <= n ; i++)
            for(int j = 0 ; j <= sum ; j++) dp[i][j] = -1;
        return helper(arr,n,0,0,sum);
    }
}

// Time COmplexity: O(n * S) => S is the sum of all elements 
// Time COmplexity: O(n * S)
