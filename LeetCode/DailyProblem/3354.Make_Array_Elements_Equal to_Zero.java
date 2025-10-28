// Topics: Simulation, prefix-sum

class Solution {
    public int countValidSelections(int[] nums) {
        int n = nums.length, sum = nums[0];
        int[] prefix = new int[n];
        prefix[0]  = nums[0];
        for(int i = 1; i<n ; i++){
            prefix[i] = prefix[i-1] + nums[i];
            sum += nums[i];
        } 
        int cnt = 0;
        for(int i = 0 ; i<n ; i++){
            if(nums[i]==0){
               if(prefix[i]==sum-prefix[i]) cnt += 2;
               else if(Math.abs(sum-2 * prefix[i])==1) cnt++;
            }
        }
        return cnt;
    }
}

// Time Complexity: O(n)
// Auxiliary Space: O(1)
