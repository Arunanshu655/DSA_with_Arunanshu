// Topics: Greedy, Sorting

class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        int ans = 1, n = nums.length;
        Arrays.sort(nums);
        nums[0] -= k;
        for(int i = 1 ; i < n ; i++){
           int l = nums[i] - k, r = nums[i] + k;
           if(nums[i]-k>nums[i-1]){
            nums[i] -= k;
            ans++;
           }
           else if(nums[i-1]+1>=l && nums[i-1]+1<=r){
            nums[i] = nums[i-1]+1;
            ans++;
           }
           else nums[i] = nums[i-1];
        }
        return ans; 
    }
}


// Time Complexity: O(nlogn);
// Auxiliary Space: O(1);
