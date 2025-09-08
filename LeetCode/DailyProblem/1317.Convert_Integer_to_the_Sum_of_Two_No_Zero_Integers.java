// Topics: Math

class Solution {
    public boolean nonZero(int n){
        if(n==0) return false;
        while(n != 0){
            if(n % 10 == 0) return false;
            n /= 10;
        }
        return true;
    }
    public int[] getNoZeroIntegers(int n) {
        
        for(int i = 1 ; i < n ; i++){
            if(nonZero(i) && nonZero(n-i)) return new int[]{i,n-i};
        }

        return new int[]{-1,-1};
    }
}

// Time Complexity: O(nlogn)
// Auxiliary Space: O(1)
