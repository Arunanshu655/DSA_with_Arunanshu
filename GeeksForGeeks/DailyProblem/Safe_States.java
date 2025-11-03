// Topics: BFS, Graph

class Solution {
    public ArrayList<Integer> safeNodes(int V, int[][] edges) {
        // Code here
        int[] outGo = new int[V];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V ; i++) adj.add(new ArrayList<>());
        for(int[] edge : edges){
            int a = edge[0];
            int b = edge[1];
            outGo[a]++;
            adj.get(b).add(a);
        }
        boolean[] visit = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < V ; i++){
            if(outGo[i]==0){
                q.add(i);
            visit[i] = true;
            } 
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        boolean[] safe = new boolean[V];
        while (!q.isEmpty()) {
            int node = q.poll();
            safe[node] = true;
            for (int neigh : adj.get(node)) {
                outGo[neigh]--;
                if (outGo[neigh] == 0) q.add(neigh);
            }
        }
        
        for (int i = 0; i < V; i++)
            if (safe[i]) ans.add(i);
        
        return ans;
    }
}

// Time Complexity: O(V + E)
// Auxiliary Space: O(V)
