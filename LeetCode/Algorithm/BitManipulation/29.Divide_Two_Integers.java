// Topics : Math. Bit Manipulation


// Q=>
//   Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.

// The integer division should truncate toward zero, which means losing its fractional part. For example, 8.345 would be truncated to 8, and -2.7335 would be truncated to -2.

// Return the quotient after dividing dividend by divisor.

// Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231, 231 − 1]. For this problem, if the quotient is strictly greater than 231 - 1, then return 231 - 1, and if the quotient is strictly less than -231, then return -231.

 

class Solution {
    public int divide(int dividend, int divisor) {
         if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if(dividend==divisor) return 1;
        boolean sign = true;
        if(dividend>=0 && divisor<0) sign = false;
        if(dividend<0 && divisor>0) sign = false;
        long Q = Math.abs((long)dividend);
        long d = Math.abs((long)divisor);
        long ans = 0;
        while(Q>=d){
            int cnt = 0;
            while(Q>=(d<<cnt)){
                cnt++;
            }
            cnt--;
            Q -= (d<<cnt);
            ans+=(1<<cnt);
            }
            
            if(ans>Integer.MAX_VALUE && sign) return Integer.MAX_VALUE;
            if(ans>Integer.MAX_VALUE && !sign) return Integer.MIN_VALUE;
            if(sign==false) return (int)(-1*ans);
            return (int) ans;
    }
}


// Time Complexity : O(log(Dividend))
// Auxiliary Space: O(1)
