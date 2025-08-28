// Topics: Sliding Window

class Solution {
    public int maxOnes(int arr[], int k) {
        // code here
        int len = 0, i = 0 , j = 0, n = arr.length, tempK = k;
        while(j<n){
            if(arr[j]==1) j++;
            else {
                len = Math.max(len,j-i);
                while(tempK!=k && tempK==0){
                    if(arr[i] == 0) tempK++;
                    i++;
                }
                if(tempK>0){
                    tempK--;
                }else i = j+1;
                j++;
            }
        }
        len = Math.max(len,j-i);
        return len;
    }
}

// Time Complexity: O(n)
// Auxiliary Space: O(1)
