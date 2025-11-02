// Topics: DAG, Math, topological-sort

class Solution {
    public int maxEdgesToAdd(int V, int[][] edges) {
        // Code here
        int totalEdges = (V * (V-1)) / 2;
        
        return (totalEdges-edges.length);
    }
}

// Time Complexity: O(1)
// Auxiliary Space: O(1)
