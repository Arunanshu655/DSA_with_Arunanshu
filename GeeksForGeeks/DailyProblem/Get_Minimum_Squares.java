// Topics: Dynamic Programming

class Solution {
    int[] dp = new int[10001];
    int helper(int n){
        if(n<=0) return 0;
        if(n==1) return 1;
        if(dp[n] != -1) return dp[n];
        
        int ans = n;
        for(int i = 1 ; i * i <= n ; i++){
            ans = Math.min(ans, 1 + helper(n- i * i));
        }
        dp[n] = ans;
        return dp[n];
    }
    public int minSquares(int n) {
        // Code here
        
        Arrays.fill(dp,-1);
        
        return helper(n);
    }
}

// Time Complexity: O(n * sqrt(n))
// Auxiliary Space: O(n)
