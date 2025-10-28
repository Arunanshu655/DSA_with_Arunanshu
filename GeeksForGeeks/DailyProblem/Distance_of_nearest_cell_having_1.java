// Topics: Matrix, Graph, BFS

class Solution {
    public ArrayList<ArrayList<Integer>> ans;
   
    public ArrayList<ArrayList<Integer>> nearest(int[][] grid) {
        // code here
        int m = grid.length, n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        ans = new ArrayList<>();
        boolean[][] visit = new boolean[m][n]; //0 no visit, 1 incomplete visit, 2 comlete visit
        for(int i = 0 ; i < m ; i++){
            ans.add(new ArrayList<>());
            for(int j = 0 ; j < n ; j++) ans.get(i).add(Integer.MAX_VALUE);
        } 
        for(int i = 0 ; i < m ; i++)
            for(int j = 0 ; j < n ; j++) if(grid[i][j]==1){
                q.add(new int[]{i,j,0});
                visit[i][j] = true;
            } 
            
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int[] dir = {-1,0,1,0,-1};

            ans.get(curr[0]).set(curr[1],curr[2]);
            for(int i = 0 ; i < 4 ; i++){
                int x = curr[0] + dir[i];
                int y = curr[1] + dir[i+1];
                
                if(x>=m || y >=n || x<0 || y<0) continue;
                if(visit[x][y]) continue;
                visit[x][y] = true;
                q.add(new int[]{x,y,curr[2]+1});
            }
        }
        
        return ans;
    }
}

// Time Complexity: O(n * m)
// Auxiliary Space: O(n * m)

  
