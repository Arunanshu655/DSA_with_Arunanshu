// Topics: Arrays, String

class Solution {
    public int numSub(String s) {
        int len = 0, n = s.length(), idx = 0, MOD = 1000000007;
        long ans = 0;
        while(idx < n){
            if(s.charAt(idx)=='0'){
                ans = (ans + (long)len * (len + 1) / 2) % MOD;
                len = 0;
            }
            else len++;
            idx++;
        }
        ans = (ans + (long)len * (len + 1) / 2) % MOD;
        return (int)(ans);
    }
}

// Time Complexity: O(n)
// Auxiliary Space: O(1)
