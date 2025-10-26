// Topics: Heap

class Solution {
    public static int minCost(int[] arr) {
        // code here
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int a: arr) pq.add(a);
        int cost = 0;
        while(pq.size()>1){
            int fst = pq.poll();
            int snd = pq.poll();
            cost += fst+snd;
            pq.add(fst+snd);
        }
        return cost;
    }
}

// Time Complexity: O(n log n)
// Auxiliary Space: O(n)
