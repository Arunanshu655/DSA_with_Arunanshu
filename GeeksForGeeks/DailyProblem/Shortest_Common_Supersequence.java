// Topics: Dynamic Programming

class Solution {
    public static int minSuperSeq(String s1, String s2) {
        // code here
        int n = s2.length(), m = s1.length();
        int[] dp = new int[n+1];
        
        for (int i = 1; i <= m; i++) {
            int prev = 0;
            for (int j = 1; j <= n; j++) {
                int temp = dp[j];
                if (s1.charAt(i-1) == s2.charAt(j-1))
                    dp[j] = 1 + prev;
                else
                    dp[j] = Math.max(dp[j-1], dp[j]);
                prev = temp;
            }
        }
        
        return m + n - dp[n];
        
    }
}

// Time Complexity: O(m * n)
// Auxiliaru Space: O(n)
