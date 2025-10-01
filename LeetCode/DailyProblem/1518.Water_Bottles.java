// Topics: Math, Simulation

class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = 0, emptyBottles = 0;
        while(numBottles > 0){
            ans += numBottles;
            emptyBottles += numBottles;
            numBottles = (emptyBottles / numExchange);
            emptyBottles = (emptyBottles % numExchange);
        }
        return ans;
    }
}

// Time Complexity: O(log(numBottles)/log(numExchange));
// Auxiliary space: O(1);
