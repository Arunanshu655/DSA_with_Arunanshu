// Topics: Dynamic Programming

class Solution {

    public boolean isInterleave(String s1, String s2, String s3) {
        // code here
        if(s1.length() + s2.length() !=s3.length()) return false;
        int n = s1.length(), m = s2.length(), k = s3.length()-1;
        int[][]dp = new int[n+1][m+1];
        // for(int[] d : dp) Arrays.fill(d,-1);
        dp[n][m] = 1;
        for(int i = n; i>=0 ; i--){
            for(int j = m; j>=0 ; j--){
                if(i==n && j==m) continue;
                int ans = 0;
                if(i< n && s1.charAt(i) == s3.charAt(i+j)) ans |= dp[i+1][j];
                if(j< m && s2.charAt(j) == s3.charAt(i+j)) ans |= dp[i][j+1];
                dp[i][j] = ans;
            }
        }
        
        // for(int[] d : dp){
        //     for(int d1 : d) System.out.print(d1 + " ");
        //     System.out.println();
        // }
        return dp[0][0]==1?true:false;
    }
}

// Time Complexity: O(n * m)
// Auxiliary Space: O(m)
