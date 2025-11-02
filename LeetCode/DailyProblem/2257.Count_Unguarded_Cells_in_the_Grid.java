// Topics: Matrix, Simulation

class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] ans = new int[m][n];

        for (int[] row : ans) { Arrays.fill(row, 0); }
        int num = m*n;
        
        for(int i = 0 ; i < walls.length ;i++){
            int a = walls[i][0];
            int b = walls[i][1];
            ans[a][b] = 2;
            
            num--;
        }
        for(int i =  0 ; i < guards.length ;i++){
            int a = guards[i][0];
            int b = guards[i][1];
            if(ans[a][b]==0){
            ans[a][b] = 3;
            num--;
            }
        }
        for(int i = 0 ; i < guards.length ;i++){
            int a = guards[i][0];
            int b = guards[i][1];
            //right
            int c = a , d = b+1;
            while(d<n && ans[c][d]!=2 && ans[c][d]!=3){
                if(ans[c][d]==0){ 
                    ans[c][d] = 1;
                
                    num--;
                    }
                d++;
            }
            // left
            c = a ; d = b-1;
            while(d>=0 && ans[c][d]!=2 && ans[c][d]!=3){
                if(ans[c][d]==0){ 
                    ans[c][d] = 1;
                    
                    num--;
                    }
                d--;
            }
            // up
            c = a-1 ; d = b;
          
            while(c>=0 && ans[c][d]!=2 && ans[c][d]!=3){
                if(ans[c][d]==0){ 
                    ans[c][d] = 1;
                 
                    num--;
                    }
                c--;
            }
            // down
            c = a+1 ; d = b;
            while(c<m && ans[c][d]!=2 && ans[c][d]!=3){
                if(ans[c][d]==0){ 
                    ans[c][d] = 1;
                    
                    num--;
                    }
                c++;
            }
        }

        return num;
    }
}

// Time Complesity : O(m*n)
// Auxiliary Space : O(m*n)
