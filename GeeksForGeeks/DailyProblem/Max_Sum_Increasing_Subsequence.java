// Topics: Dynamic Programming

class Solution {
    int[][] dp;
    public int helper(int idx, int prev, int arr[]){
        if(idx==arr.length) return 0;
        
        
        if(dp[idx][prev+1] != 0) return dp[idx][prev+1];
        int take = 0 ;
        if(prev == -1 || arr[idx]>arr[prev]) take = arr[idx] + helper(idx+1, idx, arr);
        int notTake = helper(idx+1, prev, arr);
        
        dp[idx][prev+1] =  Math.max(take, notTake);
        return dp[idx][prev+1];
        
    }
    public int maxSumIS(int arr[]) {
        // code here
        dp = new int[arr.length+1][arr.length+2]; 
        return helper(0,-1,arr);
    }
}

// Time Complexity: O(n log n)
// Auxiliary Space: O(n)
