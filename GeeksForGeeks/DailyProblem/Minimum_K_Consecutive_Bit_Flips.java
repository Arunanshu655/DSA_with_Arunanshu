// Topics: Sliding Window, Queue

class Solution {
    public int kBitFlips(int[] arr, int k) {
        // code here
        int flips = 0, n = arr.length;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i<n ; i++){
            while(!q.isEmpty() && i>q.peek()) q.poll();
            int curr = arr[i];
            if(!q.isEmpty()){
                curr = ((curr + (q.size()%2)) % 2);
            }
            if(curr==0){
                if(i+k-1>=n) return -1;
                flips++;
                q.add(i+k-1);
            } 
        }
        return flips;
    }
}

// Time COmplexity: O(n);
// Auxiliary Space: O(k);
