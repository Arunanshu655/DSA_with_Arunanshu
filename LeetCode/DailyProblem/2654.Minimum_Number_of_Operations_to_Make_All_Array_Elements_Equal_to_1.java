// Topics: Array
// Math
// Number Theory


class Solution {
    public int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b); 
    }
    public int minOperations(int[] nums) {
        int count = 0, len = Integer.MAX_VALUE, n = nums.length;
        for(int num : nums) if(num != 1) count++;
        if (count < n) return count;
        for(int i = 0 ; i < n ; i++){
            int g = nums[i];
            for(int j = i+1; j < n ; j++){
               g = gcd(g,nums[j]);
               if(g==1){
                    len = Math.min(len, j-i+1);
                    break;
               }
            }
        }
        if(len == Integer.MAX_VALUE) return -1;
        return (count-1)+(len-1);
    }
}

// Time Complexity: O(n^2 * log(max(nums)))
// Auxiliary Space: O(1);
