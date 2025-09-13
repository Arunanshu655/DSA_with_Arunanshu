// Topics: Greedy, Sorting

class Solution {
    public static int minCost(int n, int m, int[] x, int[] y) {
        // code here
        int horSeg = 1, verSeg = 1, ans = 0;
        Arrays.sort(x);
        Arrays.sort(y);
        int i = m-2, j = n-2;
        while(i>=0 && j >= 0){
            if(x[i]>y[j]){
                verSeg++;
                ans += (x[i] * horSeg);
                i--;
            }else{
                horSeg++;
                ans += (y[j] * verSeg);
                j--;
            }
        }
        while(i>=0){
                verSeg++;
                ans += (x[i] * horSeg);
                i--;
        }
        while(j>=0){
               horSeg++;
               ans += (y[j] * verSeg);
               j--;
        }
        
        return ans;
    }
}


// Time Complexity: O(n*logn + m*logm)
// Auxiliary Space: O(1)
