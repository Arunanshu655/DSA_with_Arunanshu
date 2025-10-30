// Topics: Matrix, Graph, BFS

class Solution {
    public void fill(char[][] grid) {
        // Code here
        int m = grid.length,n = grid[0].length;
        boolean[][] visit = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        
        for(int i : new int[]{0,m-1}){
            for(int j = 0 ; j < n ; j++) if(grid[i][j]=='O') q.add(new int[]{i,j});
        }
        for(int i = 0 ; i < m ; i++){
            for(int j : new int[]{0,n-1}) if(grid[i][j]=='O') q.add(new int[]{i,j});
        }
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            visit[curr[0]][curr[1]] = true;
            grid[curr[0]][curr[1]] = 'V';
            int[] dir = {-1,0,1,0,-1};
            for(int i = 0 ; i < 4 ; i++){
                int x = curr[0] + dir[i];
                int y = curr[1] + dir[i+1];
                if(x>=m || y >=n || x<0 || y<0) continue;
                if(visit[x][y]) continue;
                if(grid[x][y]=='O')q.add(new int[]{x,y});
            }
        }
        for(int i = 0 ; i < m ; i++){
            for(int j = 0; j<n ; j++){
                if(grid[i][j]=='V') grid[i][j] = 'O';
                else if(grid[i][j]=='O') grid[i][j] = 'X';
            }
        }
        
    }
}

// Time Complexity: O(n * m)
// Auxiliary Space: O(n * m)
