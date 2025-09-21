// Topics: Bit manipulation

// QS=>
//   Given an integer array nums, in which exactly two elemen
// ts appear only once and all the other elements appear exactly 
//   twice. Find the two elements that appear only once. You can return the answer in any order. 
//   You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.

 
class Solution {
    public int[] singleNumber(int[] nums) {
        long xor = 0;
        for(int num : nums) xor ^= num;
        long leftSet = (xor & xor-1) ^ xor;
        long ans1 = 0 , ans2 = 0;
        for(int num : nums) {
            if(((long)num & leftSet) != 0) ans1 ^= num;
            else ans2 ^= num;
        } 
        return new int[]{(int)(ans1),(int)(ans2)};
    }
}

// Time Complexity: O(n)
// Auxiliary Space: O(1);
