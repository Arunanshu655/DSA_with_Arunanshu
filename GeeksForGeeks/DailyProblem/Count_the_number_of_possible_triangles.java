// Topics: Arrays, sorting 

class Solution {
    public int countTriangles(int arr[]) {
        // code here
        Arrays.sort(arr);
        int n = arr.length;
        int cnt = 0;
        for(int i = n - 1 ; i >= 2 ; i--){
            int l = 0 , r = i-1;
            while(l<r){
                int sum = arr[l] + arr[r];
                if(sum>arr[i]){
                    cnt += (r-l);
                    r--;
                }else l++;
            }
        }
        
        return cnt;
    }
}

// Time Complexity: O(n^2)
// Auxiliary Space: O(1)
