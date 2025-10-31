// Topics: Graph, DFS, BFS

class Solution {
    public int minLen = Integer.MAX_VALUE;
    public int bfs(List<List<Integer>> adj, int start, int V){
        int[] dist = new int[V];
        Arrays.fill(dist, -1);
        Queue<int[]> q = new LinkedList<>();
        dist[start] = 0;

        for (int neigh : adj.get(start)) {
            q.add(new int[]{neigh, start});
            dist[neigh] = 1;
        }

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int node = curr[0], parent = curr[1];

            for (int neigh : adj.get(node)) {
                if (dist[neigh] == -1) {
                    dist[neigh] = dist[node] + 1;
                    q.add(new int[]{neigh, node});
                } else if (neigh != parent) {
                    // Found a cycle
                    return dist[node] + dist[neigh] + 1;
                }
            }
        }

        return Integer.MAX_VALUE;
    }
    public int shortCycle(int V, int[][] edges) {
        // Code here
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < V ; i++) adj.add(new ArrayList<>());
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int minLen = Integer.MAX_VALUE;
        for(int i = 0 ; i < V ; i++){
            int len = bfs(adj, i, V);
            minLen = Math.min(len, minLen);
        } 
        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }
}

// Time Complexity: O(V * (V + E))
// Auxiliary Space: O(V)
