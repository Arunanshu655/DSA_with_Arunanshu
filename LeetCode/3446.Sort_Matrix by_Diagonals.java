Topics: Sorting, Matrix

class Solution {
    public void diagSort1(ArrayList<Integer> aL){
        int n = aL.size();
        for(int i = 0 ; i < n ; i++){
            boolean isSwap = false;
            for(int j = 1 ; j < n - i ; j++) {
                  if(aL.get(j)<aL.get(j-1)){
                    int temp = aL.get(j);
                    aL.set(j,aL.get(j-1));
                    aL.set(j-1,temp);
                    isSwap = true;
                  }
            }
            if(!isSwap) return;
        }
    }
    public void diagSort2(ArrayList<Integer> aL){
        int n = aL.size();
        for(int i = 0 ; i < n ; i++){
            boolean isSwap = false;
            for(int j = 1 ; j < n - i ; j++) {
                  if(aL.get(j)>aL.get(j-1)){
                    int temp = aL.get(j);
                    aL.set(j,aL.get(j-1));
                    aL.set(j-1,temp);
                    isSwap = true;
                  }
            }
            if(!isSwap) return;
        }
    }
    public int[][] sortMatrix(int[][] grid) {
           int n = grid.length;
           //sorting bottom-left
           for(int i = 0 ; i < n ; i++){
               int x = i, y = 0, idx = 0;
               ArrayList<Integer> temp = new ArrayList<>();
               while(x<n && y<n){
                   temp.add(grid[x][y]);
                   x++;
                   y++;
               }
               diagSort2(temp);
               x = i; y = 0;
               while(x<n && y<n){
                   grid[x][y] = temp.get(idx++);
                   x++;
                   y++;
               }
           }
           //sorting top-right
           for(int i = 1 ; i < n ; i++){
               int x = 0, y = i, idx = 0;
               ArrayList<Integer> temp = new ArrayList<>();
               while(x<n && y<n){
                   temp.add(grid[x][y]);
                   x++;
                   y++;
               }
               diagSort1(temp);
               x = 0; y = i;
               while(x<n && y<n){
                   grid[x][y] = temp.get(idx++);
                   x++;
                   y++;
               }
           }
           return grid;
    }
}

Time Complexity; O(n^3);
Auxiliary Space: O(n);
