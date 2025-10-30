// Topics: Graph, DFS


class Solution {
    public int diameter = 0;
    public int dfs(int v, ArrayList<ArrayList<Integer>> adjList,boolean[] visit){
        if(visit[v]) return 0;
        int fst = 0, snd = 0;
        visit[v] = true;
        for(int neighbour : adjList.get(v)){
            int len = dfs(neighbour, adjList, visit);
            
            if(len>fst){
                snd = fst;
                fst = len; 
            } 
            else if(len>snd) snd = len;
        }
        diameter = Math.max(diameter,(fst+snd));
        
        return 1+Math.max(fst,snd);
    }
    public int diameter(int V, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < V ; i++){
            adjList.add(new ArrayList<Integer>());
        }
        boolean[] visit = new boolean[V];
        for(int[] edge : edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        } 
        for(int i = 0 ; i < V ; i++){
            if(!visit[i]) dfs(0,adjList,visit);
        }
        
        return diameter;
    }
}


// Time Complexity: O(n)
// Auxiliary Space: O(n)
