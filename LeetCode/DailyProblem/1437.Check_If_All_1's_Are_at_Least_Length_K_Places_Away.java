// Topics: Array

class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int len = 0;
        boolean first = false;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i]== 1){
                if(!first){
                    first = true;
                    len = 0;
                    continue;
                }
                if(len<k) return false;
                else len = 0;
            }
            else len++;
        }
        return true;
    }
}

// Time Complexity: O(n);
// Auxiliary Space: O(1);
