// Topics: Soritng, Heap

class Solution {
    public void nearlySorted(int[] arr, int k) {
        // code here
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = arr.length, idx = 0;
        for(int i = 0 ; i < n ; i++){
            pq.add(arr[i]);
            if(pq.size()>k){
                arr[idx++] = pq.poll();
            }
        }
        
        
        while(pq.size()>0){
            arr[idx++] = pq.poll();
        }
        
    }
}


// Time Complexity: O(n log k)
// Auxiliary Space: O(k)
