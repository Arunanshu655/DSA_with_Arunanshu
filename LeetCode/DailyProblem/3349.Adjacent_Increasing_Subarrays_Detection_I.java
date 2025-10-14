// Topics: Array

class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        boolean prev = false;
        int n = nums.size();

        for (int i = 0; i <= n - 2 * k; i++) {
            boolean first = true, second = true;

            for (int j = i; j < i + k - 1; j++) {
                if (nums.get(j) >= nums.get(j + 1)) {
                    first = false;
                    break;
                }
            }

            if (first) {
                for (int j = i + k; j < i + 2 * k - 1; j++) {
                    if (nums.get(j) >= nums.get(j + 1)) {
                        second = false;
                        break;
                    }
                }
                if (second) return true;
            }
        }

        return false;
    }
}

// Time Complexity : O(n * k);
// Auxiliary Space : O(1);
