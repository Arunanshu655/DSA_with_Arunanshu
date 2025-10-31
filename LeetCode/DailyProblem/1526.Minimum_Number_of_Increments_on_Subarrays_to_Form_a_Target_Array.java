// Topics: Greedy, Monotonic Stack

class Solution {
    public int minNumberOperations(int[] target) {
        int prev = 0, n = target.length, cnt = 0;
        for(int i = 0 ; i < n ; i++){
            if(target[i]>=prev){
                cnt += (target[i]-prev);
            }
            prev = target[i];
        }
        return cnt;
    }
}

// Time Complexity : O(n)
// Auxiliary Space: O(1)
