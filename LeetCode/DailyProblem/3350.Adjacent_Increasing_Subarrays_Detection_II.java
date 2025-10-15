// Topics: Binary Search

class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        int[] inc = new int[n];
        inc[n - 1] = 1;

        for (int i = n - 2; i >= 0; i--) {
            if (nums.get(i) < nums.get(i + 1))
                inc[i] = inc[i + 1] + 1;
            else
                inc[i] = 1;
        }

        for (int i = 0; i + 2 * k <= n; i++) {
            if (inc[i] >= k && inc[i + k] >= k)
                return true;
        }

        return false;
    }

    public int maxIncreasingSubarrays(List<Integer> nums) {
        int l = 1, r = nums.size() / 2, ans = 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (hasIncreasingSubarrays(nums, mid)) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}

// TIme complexity : O(nlogn)
// Auxiliary Space: O(1)
