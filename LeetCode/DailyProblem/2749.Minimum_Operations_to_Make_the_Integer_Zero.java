// Topics: Bit Manipulation

class Solution {
    public long setBitCnt(long num ){
        long cnt = 0;
        while(num != 0){
            if((num & 1) != 0) cnt++;
            num >>= 1;  
        }
        return cnt;
    }
    public int makeTheIntegerZero(int num1, int num2) {
        for(int x = 1 ; x <= 60 ; x++){
            long rem = num1 - ((long) x) * num2;
            if(x>rem) return -1;
            long cnt = setBitCnt(rem);
            if(x>=cnt) return x;
        }
        return -1;
    }
}

// Time Complexity: O(1);
// Auxiliary Space: O(1);
