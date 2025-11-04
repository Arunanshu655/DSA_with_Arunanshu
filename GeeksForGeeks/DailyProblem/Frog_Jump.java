// Topics: Dynamic Programming

class Solution {
    int minCost(int[] height) {
        // code here
        int n = height.length;
        int[] dp = new int[n];
        for(int i = 0 ; i < n ; i++) dp[i] = Integer.MAX_VALUE;
        dp[n-1] = 0;
        for(int i = n-1 ; i-1>= 0 ; i--){
            dp[i-1] = Math.min(dp[i] + Math.abs(height[i]-height[i-1]),dp[i-1]);
            if(i-2>=0)dp[i-2] = Math.min(dp[i] + Math.abs(height[i]-height[i-2]),dp[i-2]);
        }
        
        return dp[0];
    }
}

// Time Complexity: O(n)
// Auxiliary Space: O(1)
