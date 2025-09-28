// Topics: Sorting, Math, Greedy

class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int i = nums.length-1;
        while(i-2>=0){
           if(nums[i-1]+nums[i-2]>nums[i]){
            return nums[i-1]+nums[i-2]+nums[i];
           }
           i--;
        }
        return 0;
    }
}

// Time Complexity: O(n);
// Auxiliary Space: O(1);
