// Topics: Dynamic Programming

class Solution {
    public int[][][] dp;
    public int helper(int[][] cnt, int one, int zero, int idx, int m, int n, int[][][] dp){
        if(idx==cnt.length) return 0;

        if(dp[one][zero][idx] != -1) return dp[one][zero][idx];
        int incl = ((one + cnt[idx][1]<=n) && (zero + cnt[idx][0]<=m)) ? (1+helper(cnt, one + cnt[idx][1], zero + cnt[idx][0], idx+1, m, n, dp) ): 0;
        int excl = helper(cnt, one, zero, idx+1, m, n, dp);

        dp[one][zero][idx] = Math.max(incl, excl);
        return dp[one][zero][idx];
    }
    public int findMaxForm(String[] strs, int m, int n) {
        int k = strs.length, idx = 0;
        int[][] cnt = new int[k][2];
        dp = new int[101][101][k+1];
        for(int[][] d1 : dp){
            for(int[] d2 : d1) Arrays.fill(d2,-1);
        }
        for(String str : strs){
            int k1 = str.length(), c = 0;
            for(int i = 0; i<k1 ; i++) if(str.charAt(i)=='0') c++;
            cnt[idx][0] = c;
            cnt[idx++][1] = k1 - c;
            // System.out.println(cnt[idx-1][0]+" : "+cnt[idx-1][1]);
        }
        
        return helper(cnt, 0, 0, 0, m, n, dp);
    }
}

// Time Complexity: O(m * n * length(strs));
// Time Complexity: O(m * n * length(strs));
