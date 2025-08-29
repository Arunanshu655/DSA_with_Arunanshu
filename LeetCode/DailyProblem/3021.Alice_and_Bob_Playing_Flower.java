// Topics: Mathematics

class Solution {
    public long flowerGame(int n, int m) {
        long nOdds = (n%2==0) ? (n/2) : (n/2+1);
        long mOdds = (m%2==0) ? (m/2) : (m/2+1);
        long ans = (nOdds * (m/2)) + (mOdds * (n/2));
        return ans;
    }
}

// Time Complexity: O(1);
// Auxiliary Space: O(1);
