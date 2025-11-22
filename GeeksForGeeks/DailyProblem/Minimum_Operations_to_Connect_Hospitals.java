// Topics: Graph, Connected Components

class Solution {
    public void findComps(boolean[] visit, int idx, List<List<Integer>> adj){
        
        visit[idx] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(idx);
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int neigh : adj.get(curr)){
                if(!visit[neigh]) q.add(neigh);
                visit[neigh] = true;
            }
        }
       
    }
    
    public int minConnect(int V, int[][] edges) {
        // code here
        if(edges.length < (V - 1)) return -1;
        boolean[] visit = new boolean[V];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < V ; i++) adj.add(new ArrayList<>());
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int k = 0, ans = 0, cyc = 0;
        for(int i = 0 ; i < V ; i++){
            if(!visit[i]){
                k++;
                findComps(visit,i, adj);
            }
        }
        
        // System.out.println(k +" : "+ cyc);
        return k - 1;
    }
}

// Time Complexity: O(V + E)
// Auxiliary Space: O(V + E)
