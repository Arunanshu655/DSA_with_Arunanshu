// Topics: String, Greedy

class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = colors.length(), ans = 0;
        int i = 0;
        
        while (i < n) {
            int j = i;
            int maxTime = neededTime[i];
            int sum = neededTime[i];
            
            while (j + 1 < n && colors.charAt(j) == colors.charAt(j + 1)) {
                j++;
                maxTime = Math.max(maxTime, neededTime[j]);
                sum += neededTime[j];
            }
            
            if (j > i) {
                ans += sum - maxTime;
            }
            
            i = j + 1;
        }
        return ans;
    }
}

// Time Complexity: O(n);
// Auxiliary Space: O(1);
