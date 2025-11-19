// Topics: Graph, DFS, BFS

class Solution {
    public int minCostPath(int[][] mat) {
        // code here
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            return Integer.compare(a[2],b[2]);
        });
        int n = mat.length, m = mat[0].length;
        int[][] effort = new int[n][m];
        for (int[] row : effort) Arrays.fill(row, Integer.MAX_VALUE);
        pq.add(new int[]{0,0,0});
        int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int x = curr[0], y = curr[1], cost = curr[2];
            // System.out.println(x+" : "+y);
            if(x==n-1 && y==m-1) return cost;
            for(int i = 0 ; i < 4 ; i++){
                int nX = x + dir[i][0], nY = y + dir[i][1];
                if(nX>=0 && nY<m && nX<n && nY>=0){
                    int newCost = Math.max(cost,Math.abs(mat[x][y]-mat[nX][nY]));
                    if(newCost < effort[nX][nY]){
                        effort[nX][nY] = newCost;
                        pq.add(new int[]{nX,nY,newCost});
                    }
                }
            }
        }
        return -1;
    }
}


// Time Complexity: O(n * m log (n * m))
// Auxiliary Space: O(n * m)
