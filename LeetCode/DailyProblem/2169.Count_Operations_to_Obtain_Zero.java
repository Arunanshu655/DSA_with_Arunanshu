// Topics: Math, Simulation

class Solution {
    public int countOperations(int num1, int num2) {
        int ops = 0;
        while(num1 != 0 && num2 != 0){
            if(num1>=num2){
                int quo = (num1/num2);
                ops += (quo);
                num1 %= num2;
            }else {
                int quo = (num2/num1);
                ops += (quo);
                num2 %= num1;
            }
        }

        return ops;
    }
}

// Time Complexity: O(log(min(n1,n2)))
// Auxiliary Space: O(1)
