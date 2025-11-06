// Topics: Fibonacci, Dynamic Programming

class Solution {
    public int numberOfWays(int n) {
        // code here
        int one = 1, two = 2;
        if(n==1) return 1;
        for(int i = 2 ; i < n ; i++){
            int temp = one + two;
            one = two;
            two = temp;
        }
        
        return two;
    }
};


// Time Complexity: O(n)
// Auxiliary Space: O(1)
