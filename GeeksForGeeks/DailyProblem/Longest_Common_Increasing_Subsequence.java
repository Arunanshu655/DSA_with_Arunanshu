// Topics: Dynamic Programming

class Solution {
    
    public int LCIS(int[] a, int[] b) {
        // code here
        int m = a.length, n = b.length;
        int[] dp = new int[n+1];
        
        for(int i = 0 ; i < m ; i++){
            int curr = 0;
            for(int j = 0 ; j < n ; j++){
                if(a[i]==b[j]){
                    dp[j] = Math.max(dp[j],curr + 1);
                }else if(a[i]>b[j]) curr = Math.max(curr,dp[j]);
            }
        }
            
                
        int ans = 0;
        for(int i = 0 ; i < n ; i++) ans = Math.max(ans, dp[i]);
        
        return ans;
    }
}

// Time Complexity: O(n * m)
// Auxiliary Space: O(n)

  
