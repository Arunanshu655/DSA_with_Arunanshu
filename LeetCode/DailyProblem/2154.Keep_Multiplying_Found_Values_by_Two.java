// Topics: Array
// ,Hash Table
// ,Sorting

class Solution {
    public int findFinalValue(int[] nums, int original) {

        /* Approach -1 (Sorting) */
        // Arrays.sort(nums);
        // while(true){
        //     int l = 0, r = nums.length-1, ans = -1;
        //     while(l<=r){
        //         int mid = l + (r-l)/2;
        //         if(nums[mid]==original){
        //             ans = mid;
        //             break;
        //         }else if(nums[mid]>original) r = mid - 1;
        //         else l = mid + 1;    
        //     }
        //     if(ans == -1) break;
        //         original *= 2;
        // }
        // return original;

      // Time Complexity: O(nlogn)
      // Auxiliary Space: O(1)

        /* Approach -2 (Hashing) */
        // HashSet<Integer> set = new HashSet<>();
        // for(int num : nums) set.add(num);
        // while(true){
        //     if(set.contains(original)) original *= 2;
        //     else break;
        // }
        // return original;

        // Time Complexity: O(n)
        // Auxiliary Space: O(n)

    }
}

