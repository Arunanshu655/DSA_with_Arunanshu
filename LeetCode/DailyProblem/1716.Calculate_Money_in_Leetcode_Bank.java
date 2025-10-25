// Topics: Math

class Solution {
    public int totalMoney(int n) {
        int day = 0, prev = 0, sum = 0, prevMon = 0;
        while(n>0){
            if(day == 0){
                prev = prevMon;
                prevMon++;
            }
            prev++;
            sum += prev;
            day++;
            day %= 7;
            n--;
        }
        return sum;
    }
}

// Time Complexity: O(n)
// Auxiliary Space: O(1)
