// Topics: Binary Search

class Solution {
    public boolean isPos(int[] arr,int target, int k){
        int n = arr.length, idx;
        if(n%2==0) idx = n/2 - 1;
        else idx = n/2;
        
        for(int i = idx ; i < n ; i++){
            int req = target - arr[i];
            if(req>k) return false;
            if(req<=0) return true;
            k -= req;
        }
        return true;
    }
    public int maximizeMedian(int[] arr, int k) {
        // code here
        Arrays.sort(arr);
        int n = arr.length;
        int l = (n%2==0) ? ((arr[n/2]+arr[(n/2)-1])/2) : arr[n/2];
        int r = arr[n-1] + k;
        int ans  = l;
        if(k==0) return l;
        while(l<=r){
            int m = l + (r-l)/2;
            if(isPos(arr, m, k)){
                l = m + 1;
                ans = m;
            }else r = m - 1;
        }
        return ans;
    }
}


// Time Complexity: O(nlogk)
// Auxiliary Space: O(1)
