// Topics: Dynamic Programming

class Solution {
    public int helper(int[][] jobs, int curr, int[] dp){
        if(curr == jobs.length) return 0;
        
        if(dp[curr] != -1) return dp[curr];
        
        int low = curr + 1, high = jobs.length - 1, next = jobs.length;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (jobs[mid][0] >= jobs[curr][1]) {
                next = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        int incl = 0, excl = 0;
        incl = jobs[curr][2] + helper(jobs, next, dp);
        excl = helper(jobs, curr+1, dp);
        
        dp[curr] = Math.max(incl, excl);
        return dp[curr];
    }
    public int maxProfit(int[][] jobs) {
        // code here
        Arrays.sort(jobs, (a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            else return Integer.compare(a[1], b[1]);
        });
        
        int[] dp = new int[jobs.length+1];
        Arrays.fill(dp,-1);
        // for(int[] job : jobs){
        //     System.out.println(job[0]+" : "+job[1]+" : "+job[2]);
        // }
        return helper(jobs, 0, dp);
    }
}

// Time Complexity: O(n log n)
// Auxiliary Space: O(n)
