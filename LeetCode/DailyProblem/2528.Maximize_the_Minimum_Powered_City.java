// Topics: greedy, binary-search, prefix-sum

class Solution {
    public boolean isPos(long[] power, int r, int k, long mid){
        int n = power.length;
        long[] added = new long[n];
        long extra = 0;

        for (int i = 0; i < n; i++) {
            if (i - r - 1 >= 0) extra -= added[i - r - 1];
            if (power[i] + extra < mid) {
                long need = mid - (power[i] + extra);
                if (need > k) return false;
                k -= need;
                added[Math.min(n - 1, i + r)] += need;
                extra += need;
            }
        }
        return true;
    }
    public long maxPower(int[] stations, int r, int k) {
        int n = stations.length, cnt = 0;
        long sum = 0, left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;
        long[] totStations = new long[n];
        for(int i = 0 ; i < n ; i++){
            totStations[i] = (stations[i] + sum);
            sum += stations[i];
            cnt++;
            if(cnt>r){
               sum -= stations[i-r];
               cnt--; 
            } 
        }
        cnt = 0;
        sum = 0;
        for(int i = n-1 ; i >= 0 ; i--){
            totStations[i]  +=  sum;
            left = Math.min(totStations[i],left);
            right = Math.max(totStations[i],right);
            sum += stations[i];
            cnt++;
            if(cnt>r){
               sum -= stations[i+r];
               cnt--; 
            } 
        }
        
        right += k;
        long ans = left;
        // for(long totSt : totStations) System.out.println(left+":"+right);
        while(left<=right){
            long mid = left + (right-left)/2;
            if(isPos(totStations,r,k,mid)){
                ans = mid;
                left = mid + 1;
            }else right = mid - 1;
        }
        
        return ans;
    }
}

// Time Complexity: O(nlogn)
// Auxiliary Space: O(n)
  
