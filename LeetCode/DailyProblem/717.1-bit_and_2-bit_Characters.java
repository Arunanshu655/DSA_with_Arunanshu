// Topics: Array

class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        for(int i = 0 ; i < n ; i++){
            if(bits[i]==1) i++;
            else if(i==n-1) return true;
        }
        return false;
    }
}

// Time Complexity: O(n);
// Auxiliary Space: O(1);
