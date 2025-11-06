// Topics: Union Set, Hash Table, Heap

class Solution {
    public void dfs(int child, int par, boolean[] visit, int[] parent, HashMap<Integer,TreeSet<Integer>> grid, ArrayList<ArrayList<Integer>> adj){
        visit[child] = true;
        grid.putIfAbsent(par, new TreeSet<>()); // --- O(logc)
        grid.get(par).add(child);
        parent[child] = par;

        for(int neigh : adj.get(child)){
            if(!visit[neigh]) dfs(neigh,par,visit,parent,grid,adj); 
        }
    }
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(); // --- O(c)
        for(int i = 0 ; i < c+1 ; i++) adj.add(new ArrayList<>()); // --- O(c)
        for(int[] connection : connections){ // --- O(c * (c-1)) or O(10^5)
           adj.get(connection[0]).add(connection[1]);
           adj.get(connection[1]).add(connection[0]);
        }
        HashMap<Integer,TreeSet<Integer>> grid = new HashMap<>(); // --- O(c)
        int[] parent = new int[c+1]; // --- O(c)
        boolean[] online = new boolean[c+1];// --- O(c)
        boolean[] visit = new boolean[c+1];// --- O(c)
        Arrays.fill(online,true); // --- O(c)
        for(int i = 1 ; i <= c ; i++){ // --- O(c)
            if(!visit[i]){
                dfs(i,i,visit,parent,grid,adj);
            }
        } // --- O(clogc)
        int n = 0, idx = 0;
        for(int[] query : queries) if(query[0]==1) n++; // --- O(q) :-> q = no. of queries
        int[] ans = new int[n]; // --- O(c)
        for(int[] query : queries) { // --- O(q)
            if(query[0]==1){
                int curr = query[1];
                if(online[curr]) ans[idx++] = curr;
                else if(!grid.get(parent[curr]).isEmpty()) ans[idx++] = grid.get(parent[curr]).first(); // --- O(1)
                else ans[idx++] =  -1;
            }
            else{
                int curr = query[1];
                online[curr] = false;
                grid.get(parent[curr]).remove(curr); // --- O(logc)
            }
        } // --- O(qlogc)
        return ans; // --- O(qlogc)
    }
}

// Time Complexity: O(QlogC)  e.g.;- Q = no. of queries and C is number of power stations 
// Auxiliary Space: O(C)
