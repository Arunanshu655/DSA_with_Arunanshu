// Topics: Math, Bit Manipulation

class Solution {
    public int smallestNumber(int n) {
        int temp = n, idx = 0;
        do{
            n |= (1<<idx);
            temp >>= 1;
            idx++;
        }while(temp != 0);

        return n;
    }
}

// Time Complexity: O(1);
// Auxiliary Space: O(1);
