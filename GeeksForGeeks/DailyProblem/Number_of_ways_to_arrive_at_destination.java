// Topics: Graph, Shortest path

class Solution {
    
    public int countPaths(int V, int[][] edges) {
        // code here
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0 ; i < V ; i++) adj.add(new ArrayList<>());
        for(int[] edge : edges){
            int a = edge[0], b = edge[1];
            adj.get(a).add(new int[]{b,edge[2]});
            adj.get(b).add(new int[]{a,edge[2]});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            return Integer.compare(a[1],b[1]);
        });
        
        int[] ways = new int[V];
        int[] dist = new int[V];
        int MOD = 1000000007;
        
        Arrays.fill(dist,Integer.MAX_VALUE);
        ways[0] = 1;
        dist[0] = 0;
        pq.add(new int[]{0,0});
        
        while(!pq.isEmpty()){
            int node = pq.peek()[0];
            int dis = pq.peek()[1];
            pq.poll();
            
            if (dis > dist[node]) continue;
            for(int[] i : adj.get(node)){
                int totTime = dis + i[1];
                if(totTime<dist[i[0]]){
                    ways[i[0]] = ways[node];
                    dist[i[0]] = totTime;
                    pq.add(new int[]{i[0],dist[i[0]]});
                }else if(totTime == dist[i[0]]) ways[i[0]] = (ways[i[0]] + ways[node]) % MOD;
            }
        }
        
        return ways[V-1] % MOD;
    }
}

// Time Complexity: O(V + E * log E)
// Auxiliary Space: O(V + E)
