// Topics: Greedy, counting

class Solution {
    public int maxOperations(String s) {
        int ones = 0, ans = 0, n = s.length() , i = 0;
        boolean inZero = false;
        while(i<n){
            if(s.charAt(i)-'0'==0) inZero = true;
            else{
                if(inZero) ans += ones;
                inZero = false;
                ones++;
            }
            i++;
        }
        if(inZero) ans += ones;
        return ans;
    }
}

// Time Complexity: O(n);
// Auxiliary Space: O(1);
