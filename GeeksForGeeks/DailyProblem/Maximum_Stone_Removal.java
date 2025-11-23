// Topics: Graph, Connected-Components

class Solution {
    int getComps(List<List<Integer>> adj, int idx, boolean[] visit){
        
        Queue<Integer> q = new LinkedList<>();
        int cnt = 0;
        visit[idx] = true;
        q.add(idx);
        while(!q.isEmpty()){
            int curr = q.poll();
            cnt++;
            for(int neigh : adj.get(curr)){
                if(!visit[neigh]){
                    q.add(neigh);
                     visit[neigh] = true;
                } 
            }
        }
        
        return cnt - 1;
    }
    int maxRemove(int[][] stones) {
        // Code here
        int V = stones.length, idx = 0;
        List<List<Integer>> adj = new ArrayList<>();
        Map<Integer,Integer> row = new HashMap<>();
        Map<Integer,Integer> col = new HashMap<>();
        for(int i = 0 ; i < stones.length ; i++) adj.add(new ArrayList<>());
        for(int stone[] : stones){
            int x = stone[0], y = stone[1];
            if(row.containsKey(x)){
                int ref = row.get(x);
                adj.get(ref).add(idx);
                adj.get(idx).add(ref);
            }
            else row.put(x,idx);
            if(col.containsKey(y)){
                int ref = col.get(y);
                adj.get(ref).add(idx);
                adj.get(idx).add(ref);
            }
            else col.put(y,idx);
            
            idx++;
        }
        
        boolean[] visit = new boolean[V];
        int ans = 0;
        for(int i = 0 ; i < V ; i++){
            if(!visit[i]) ans += (getComps(adj,i,visit));
        }
        
        return ans;
    }
};

// Time Complexity: O(n)
// Auxiliary Space: O(n)


