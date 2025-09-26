// Topics: Two-Pointers, Greedy, Sorting

class Solution {
    public int triangleNumber(int[] nums) {
        int n = nums.length, ans = 0;
        Arrays.sort(nums);
        for(int i = n-1; i>=2 ; i--){
            int j = 0, k = i-1;
            while(j<k){
                while((j<k) && (nums[j] + nums[k] <= nums[i])) j++;
                ans += (k-j);
                k--;
            }
        }

        return ans;
    }
}

// Time Complexity: O(n^2);
// Auxiliary Space: O(1);
