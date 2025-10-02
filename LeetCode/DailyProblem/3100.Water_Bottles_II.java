// Topics: Math, Simulation

class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int emptyBottles = 0, ans = 0;
        while(numBottles>0){
            ans += numBottles;
            emptyBottles += numBottles;
            numBottles =0;
            while(emptyBottles>=numExchange){
                numBottles++;
                emptyBottles -= numExchange;
                numExchange++;
            }
        }

        return ans;
    }
}

// Time Complexity: O(N);
// Auxiliary Space: O(1);
