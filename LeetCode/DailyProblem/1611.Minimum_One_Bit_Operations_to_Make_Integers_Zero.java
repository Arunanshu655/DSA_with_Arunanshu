// Topics : Bit manipulation

class Solution {
    public int minimumOneBitOperations(int n) {
        int transform = n;
        while(transform != 0){
            transform >>= 1;
            n ^= transform;
        }

        return n;
    }
}

// Time Complexity: O(1)
// Auxiliary Space: O(1)
