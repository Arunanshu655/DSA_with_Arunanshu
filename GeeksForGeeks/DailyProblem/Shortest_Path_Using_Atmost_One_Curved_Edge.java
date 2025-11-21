// Topics: Graph, Shortest path


class Solution {
    public int shortestPath(int V, int a, int b, int[][] edges) {
        // code here
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0 ; i < V; i++) adj.add(new ArrayList<>());
        for(int[] edge : edges){
            adj.get(edge[0]).add(new int[]{edge[1],edge[2],edge[3]});
            adj.get(edge[1]).add(new int[]{edge[0],edge[2],edge[3]});
        }
        int[][] dist = new int[2][V];
        for(int[] d : dist) Arrays.fill(d, Integer.MAX_VALUE);
        dist[0][a] = 0; dist[1][a] = Integer.MAX_VALUE;
        PriorityQueue<int[]> pq = new PriorityQueue<>((c,d)->{
            return Integer.compare(c[1],d[1]);
        });
        pq.add(new int[]{a,0,0});
        
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int isCurve = curr[2], node = curr[0], dis = curr[1];
            
            if(dist[isCurve][node]<dis) continue;
            for(int[] neigh : adj.get(node)){
                if(isCurve==1){
                    int newDis = dis + neigh[1];
                    if(newDis < dist[1][neigh[0]]) {
                    dist[1][neigh[0]] = newDis;
                    pq.add(new int[]{neigh[0],dist[1][neigh[0]],1});
                    }
                }else{
                    int newDis = dis + neigh[1];
                    if(newDis < dist[0][neigh[0]]) {
                        dist[0][neigh[0]] = newDis;
                        pq.add(new int[]{neigh[0],dist[0][neigh[0]],0});
                    }
                   
                    newDis = dis + neigh[2];
                    if(newDis < dist[1][neigh[0]]) {
                        dist[1][neigh[0]] = newDis;
                        pq.add(new int[]{neigh[0],dist[1][neigh[0]],1});
                    }
                    
                }
            }
            
        }
        int ans = Math.min(dist[0][b],dist[1][b]);
        return  ans == Integer.MAX_VALUE ? -1 : ans ;
        
    }
}

// Time Complexity: O((V + E) * log(V))
// Auxiliary Space: O(V + E)
