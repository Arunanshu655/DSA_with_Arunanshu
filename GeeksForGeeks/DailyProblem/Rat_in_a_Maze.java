// Topics: BackTracking

class Solution {
    public ArrayList<String> ans ;
    public ArrayList<String> ratInMaze(int[][] maze) {
        // code here
        ans  = new ArrayList<>();
        StringBuilder sb = new StringBuilder("");
        backTrack(maze,0,0,sb);
        Collections.sort(ans);
        return ans;
    }
    public void backTrack(int[][] maze, int x, int y, StringBuilder sb){
        if(x==maze.length || y==maze.length || y<0 || x<0) return;
        if(maze[x][y]==0) return;
        if(x==maze.length - 1 && y==maze.length - 1){
            ans.add(sb.toString());
            return;
        }
        maze[x][y] = 0;
        
        sb.append("D");
        backTrack(maze,x+1,y,sb);
        sb.delete(sb.length()-1,sb.length());
        sb.append("R");
        backTrack(maze,x,y+1,sb);
        sb.delete(sb.length()-1,sb.length());
        sb.append("U");
        backTrack(maze,x-1,y,sb);
        sb.delete(sb.length()-1,sb.length());
        sb.append("L");
        backTrack(maze,x,y-1,sb);
        sb.delete(sb.length()-1,sb.length());
        
        
         maze[x][y] = 1;
        
    }
}



// Time Complexity: O(4 ^ (n * n))
// Auxiliary Space: O(1)
