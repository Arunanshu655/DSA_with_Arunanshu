// Topics: Dynamic Programming

class Solution {
    public int helper(int i, int j, String txt, String pat, int[][] dp){
        if(i==txt.length() && j==pat.length()) return 1;
        if(j==pat.length()) return 0;
        if(i==txt.length()){
            for(int k = j ; k < pat.length() ; k++ ){
                if(pat.charAt(k) != '*') return 0;
            }
            return 1;
        }
        
        
        if(dp[i][j] != -1) return dp[i][j];
        int ans = 0;
        if(pat.charAt(j) == '?' || pat.charAt(j) == txt.charAt(i)){
            ans = helper(i+1, j+1, txt, pat, dp);
        }else if(pat.charAt(j) == '*'){
            int ans0 = helper(i+1, j+1, txt, pat, dp);
            int ans1 = helper(i+1, j, txt, pat, dp);
            int ans2 = helper(i, j+1, txt, pat, dp);
            
            ans = (ans0 != 0 || ans1 != 0 || ans2 != 0 ) ? 1 : 0;
        }
        
        
        dp[i][j] = ans;
        return dp[i][j];
    }
    public boolean wildCard(String txt, String pat) {
        // code here
        int[][] dp = new int[txt.length()+1][pat.length()+1];
        for(int[] d : dp) Arrays.fill(d,-1);
        return (helper(0, 0, txt, pat, dp) == 1) ? true : false;
    }
}

// Time Complexity: O(n * m)
// Auxiliary Space: O(n * m)
